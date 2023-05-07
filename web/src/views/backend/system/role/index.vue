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
      >
        <el-table-column prop="name" label="角色名称"  />
        <el-table-column prop="roleCode" label="角色编码" show-overflow-tooltip  />
        <el-table-column prop="status" label="状态" width="65" align="center"  >
          <template #default="scope">
            <el-switch
              v-model="scope.row.status"
              active-value="1"
              inactive-value="0"
            />
          </template>
        </el-table-column>
        <el-table-column label="操作"  width="170" >
          <template #default="scope">
            <el-button type="success" @click="openDialogForm(scope.row.id)">修改</el-button>


            <el-popconfirm title="Are you sure to delete this?"  @confirm="remove(scope.row.id)">
              <template #reference>
                <el-button type="danger">删除</el-button>
              </template>
            </el-popconfirm>

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
                  {{ form.id?'更新管理员':'添加管理员' }}
              </div>
          </template>
        <el-scrollbar v-loading="formLoading" class="ba-table-form-scrollbar">
          <div
                  class="ba-operate-form"
                  :style="'width: calc(100% - ' + formLabelWidth! / 2 + 'px)'"
              >
              <el-form :model="form" :rules="rules" ref="ruleFormRef">
                <el-form-item label="角色名称" prop="name" :label-width="formLabelWidth">
                  <el-input v-model="form.name" autocomplete="off" placeholder="请输入角色名称" />
                </el-form-item>
                <el-form-item label="角色编码" prop="roleCode" :label-width="formLabelWidth">
                  <el-input v-model="form.roleCode" autocomplete="off" placeholder="请输入角色编码" />
                </el-form-item>
                <el-form-item label="管理员状态" prop="status" :label-width="formLabelWidth">
                  <el-radio-group v-model="form.status">
                    <el-radio label="1"  border>是</el-radio>
                    <el-radio label="0"  border>否</el-radio>
                  </el-radio-group>
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
                      {{ form.id?'更新管理员':'添加管理员' }}
                  </el-button>
              </div>
          </template>
      </el-dialog>
    </div>
  </template>
  
  <script lang="ts" setup name="RoleView">
  import { getRoleList,getById,deleteRole,updateRole,insertRole } from '@/api/backend/system/role';
  import {FormInstance,ElNotification,ElForm,FormRules} from "element-plus"
  import {onResetForm} from "@/utils/common";
  
  const tableData = ref([]);
  const total =ref();
  
  const formLabelWidth = 150;
  const submitLoading = ref(false)
  const srcList = ref<any>([]);
  const formLoading = ref(false);
  const tableLoading =ref(false);
  const dialogFormVisible = ref(false);
  const ruleFormRef = ref<InstanceType<typeof ElForm>>()
  
  const form = ref({
    id:undefined,
    roleCode:"",
    name:"",
    status:"1",
    remark:"",
  });
  
  // 表单验证规则
  const rules = reactive<FormRules>({
      roleCode: [
          { required: true, message: '请输入角色编码', trigger: 'blur' },
      ],
      name: [
          {
          required: true,
          message: '请输入角色名称',
          trigger: 'blur',
          },
      ],
  })
  
  const getList=()=>{
    tableLoading.value = true;
    getRoleList().then(e=>{
        tableData.value = e.rows;
        srcList.value = tableData.value.map((e:any)=>{
          return e.avatar;
        })
        total.value = e.total;
        tableLoading.value = false;
    })
  }
  
  
  const remove=(rowId:any )=>{
    tableLoading.value = true;
    deleteRole(rowId).then(e=>{
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
  
        (!form.value.id?insertRole(form.value):updateRole(form.value))
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