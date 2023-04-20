<template>
  <div class="default-main">

    <el-row class="table-header">
      <el-col>
        <el-button type="primary" @click="openDialogForm(undefined!)">添加</el-button>
      </el-col>
    </el-row>
    <el-table

      v-loading="tableLoading"
      :data="tableData"
      style="width: 100%"
      row-key="id"
      border
      default-expand-all
    >
      <el-table-column prop="title" label="菜单标题"  />
      <el-table-column prop="name" label="菜单名称" show-overflow-tooltip  />
      <el-table-column prop="path" label="菜单路径"  />
      <el-table-column prop="icon" label="图标" width="65" align="center" >
        <template #default="scope">
          <Icon
                :name="scope.row.icon"
            />
        </template>
      </el-table-column>
      <el-table-column prop="status" label="状态" width="65" align="center"  >
        <template #default="scope">
          <el-switch
            v-model="scope.row.status"
            :active-value="1"
            :inactive-value="0"
          />
        </template>
      </el-table-column>
      <el-table-column prop="keepAlive" label="缓存" width="65" align="center"  >
        <template #default="scope">
          <el-switch :disabled="scope.row.type !== 'menu'"
            v-model="scope.row.keepAlive"
            :active-value="1"
            :inactive-value="0"
          />
        </template>
      </el-table-column>
      <el-table-column prop="type" label="类型" width="75" align="center"   >
        <template #default="scope">
          <el-tag class="mx-1" v-if="scope.row.type == 'menu'"  >菜单</el-tag>
          <el-tag class="mx-1" v-else-if="scope.row.type == 'menu_dir'" type="warning">目录</el-tag>
          <el-tag class="mx-1" v-else type="success">按钮</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="component" label="组件地址" show-overflow-tooltip  />
      <el-table-column prop="menuType" label="页面类型" width="90" align="center">
        <template #default="scope" >
          <el-tag class="mx-1" v-if="scope.row.type == 'tab'"  >选项卡</el-tag>
          <el-tag class="mx-1" v-else-if="scope.row.type == 'link'" type="warning">超链接</el-tag>
          <el-tag class="mx-1" v-else type="success">iframe</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="remark" label="备注" show-overflow-tooltip />
      <el-table-column label="操作"  width="170" >
        <template #default="scope">
          <el-button type="success" @click="openDialogForm(scope.row.id)">修改</el-button>
          <el-button type="danger" @click="remove(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>


    <el-dialog
    class="ba-operate-dialog" 
    v-model="dialogFormVisible" 
    draggable
    >
    <template #header>
            <div class="title">
                {{ form.id?'更新菜单':'添加菜单' }}
            </div>
        </template>
      <el-scrollbar v-loading="formLoading" class="ba-table-form-scrollbar">
        <div
                class="ba-operate-form"
                :style="'width: calc(100% - ' + formLabelWidth! / 2 + 'px)'"
            >
            <el-form :model="form" :rules="rules" ref="ruleFormRef">
              <el-form-item label="父级菜单" prop="pid" :label-width="formLabelWidth">
                <el-tree-select
                  v-model="form.pid"
                  :data="treeSelectData"
                  check-strictly
                  :render-after-expand="false"
                />
              </el-form-item>
              <el-form-item label="菜单类型" prop="type" :label-width="formLabelWidth">
                <el-radio-group v-model="form.type">
                  <el-radio label="menu"  border>菜单</el-radio>
                  <el-radio label="menu_dir"  border>目录</el-radio>
                  <el-radio label="button"  border>按钮</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="菜单标题" prop="title" :label-width="formLabelWidth">
                <el-input v-model="form.title" autocomplete="off" placeholder="请输入菜单标题" />
              </el-form-item>
              <el-form-item label="菜单名称" prop="name" :label-width="formLabelWidth">
                <el-input v-model="form.name" autocomplete="off" placeholder="请输入菜单名称" />
                <div class="block-help">
                    将注册为web端路由名称/注意跟组件内的name一致 不然无法缓存
                </div>
              </el-form-item>
              <el-form-item label="菜单路径" prop="path" :label-width="formLabelWidth">
                <el-input v-model="form.path" autocomplete="off" placeholder="web端路由路径(path)，无需以`/admin`开头，如:auth/menu" />
              </el-form-item>
              <el-form-item label="缓存" prop="keepAlive" :label-width="formLabelWidth">
                <el-radio-group v-model="form.keepAlive">
                  <el-radio :label="1"  border>是</el-radio>
                  <el-radio :label="0"  border>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="菜单权限" prop="perms" :label-width="formLabelWidth">
                <el-input v-model="form.perms" autocomplete="off" placeholder="请输入权限标识,例如：user:add" />
                <div class="block-help">
                    作为server端API验权使用
                </div>
              </el-form-item>
              <el-form-item label="菜单图标" prop="icon" :label-width="formLabelWidth">
                <el-input v-model="form.icon" autocomplete="off" placeholder="请选择" />
              </el-form-item>
              <el-form-item label="链接类型" prop="menuType" :label-width="formLabelWidth">
                <el-radio-group v-model="form.menuType">
                  <el-radio label="tab"  border>选项卡</el-radio>
                  <el-radio label="link"  border>外链</el-radio>
                  <el-radio label="iframe"  border>内链</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="链接地址" v-show="form.menuType !== 'tab' && form.type == 'menu'" prop="url" :label-width="formLabelWidth">
                <el-input v-model="form.url" autocomplete="off" placeholder="请输入链接或Iframe的URL地址" />
              </el-form-item>
              <el-form-item label="组件地址" v-show="form.menuType == 'tab' && form.type == 'menu' " prop="component" :label-width="formLabelWidth">
                <el-input v-model="form.component" autocomplete="off" placeholder="web端组件路径，请以/src开头，如:/src/views/backend/dashboard.vue" />
              </el-form-item>
              <el-form-item label="扩展选项" v-show="form.menuType == 'tab' && form.type == 'menu' " prop="extend" :label-width="formLabelWidth">
                <el-select
                  v-model="form.extend"
                  placeholder="请选择"
                >
                  <el-option label="只添加为菜单" value="add_menu_only" />
                  <el-option label="只添加为路由" value="add_rules_only" />
                  <el-option label="无" value="none" />
                </el-select>
                <div class="block-help">
                  比如将`auth/menu`只添加为路由，那么可以另外将`auth/menu`、`auth/menu/:a`、`auth/menu/:b/:c`只添加为菜单
                </div>
              </el-form-item>


              <el-form-item label="状态" prop="status" :label-width="formLabelWidth">
                <el-radio-group v-model="form.status">
                  <el-radio :label="1"  border>是</el-radio>
                  <el-radio :label="0"  border>否</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="排序" prop="sort" :label-width="formLabelWidth">
                <el-input type="number" v-model="form.sort" autocomplete="off"  placeholder="排序"  />
              </el-form-item>
              <el-form-item label="备注" prop="remark" :label-width="formLabelWidth">
                <el-input type="textarea" v-model="form.remark" autocomplete="off" placeholder="描述备注" />
              </el-form-item>
            </el-form>

        </div>

      </el-scrollbar>
      <template #footer>
            <div :style="'width: calc(100% - ' + formLabelWidth! / 1.8 + 'px)'">
                <el-button @click="closeDialogForm">关闭</el-button>
                <el-button :loading="submitLoading" @click="submitForm(ruleFormRef)" type="primary">
                    {{ form.id?'更新菜单':'添加菜单' }}
                </el-button>
            </div>
        </template>
    </el-dialog>
  </div>
</template>

<script lang="ts" setup name="MenuView">
import { getMenuList,insertMenu,deleteMenu,getById,updateMenu,getTreeMenuList } from '@/api/backend/system/menu';
import {FormInstance,ElForm,FormRules} from "element-plus"
import {onResetForm} from "@/utils/common";
import { ElNotification } from 'element-plus'
const tableData = ref([]);
const total =ref();

const formLabelWidth = 150;
const submitLoading = ref(false)
const formLoading = ref(false);
const tableLoading =ref(false);
const dialogFormVisible = ref(false);
const ruleFormRef = ref<InstanceType<typeof ElForm>>()

const treeSelectData = ref({});
const form = ref({
  id:undefined,
  title:"",
  pid:undefined,
  status:1,
  keepAlive:0,
  perms:"",
  icon:"",
  path:"",
  type:"menu",
  menuType:"tab",
  url:"",
  name:"",
  component:"",
  extend:"none",
  remark:"",
  sort:undefined
});

// 表单验证规则
const rules = reactive<FormRules>({
    title: [
        { required: true, message: '请输入标题', trigger: 'blur' },
    ],
})

const getList=()=>{
  tableLoading.value = true;
  getMenuList().then(e=>{
      tableData.value = e.rows;
      total.value = e.total;
      tableLoading.value = false;
  })
}

const getTreeList=()=>{
  getTreeMenuList().then(e=>{
    treeSelectData.value = e.data;
  })
}

const remove=(rowId:any )=>{
  tableLoading.value = true;
  deleteMenu(rowId).then(e=>{
    ElNotification({
          message: e.msg,
          type: 'success',
      })
      getList();
    }).finally(()=>{
      tableLoading.value = false;
    })
}

const openDialogForm=(rowId:number)=>{
  dialogFormVisible.value = true;
  resetForm();
  getTreeList();
  if(rowId){
    getById(rowId).then(e=>{
      form.value = e.data;
    })
  }
}

const closeDialogForm=()=>{
  dialogFormVisible.value = false;
  resetForm();
}


const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {

      formLoading.value = true;
      submitLoading.value = true;

      (!form.value.id?insertMenu(form.value):updateMenu(form.value))
      .then(e=>{
          ElNotification({
              message: e.msg,
              type: 'success',
          })
          getList();
        }).finally(()=>{
          formLoading.value = false;
          submitLoading.value = false;
          closeDialogForm();
        })
    } else {
      console.log('error submit!', fields)
    }
  })
}

const resetForm=()=>{
  form.value.id=undefined;
  onResetForm(ruleFormRef.value);
}



getList();
</script>


<style scoped lang="scss">

</style>