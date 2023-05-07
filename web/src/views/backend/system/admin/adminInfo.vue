<template>
    <div class="default-main">
        <el-row :gutter="30">
            <el-col class="lg-mb-20" :xs="24" :sm="24" :md="24" :lg="10">
                <div class="admin-info">
                    <el-upload
                        class="avatar-uploader"
                        action=""
                        :show-file-list="false"
                        @change="onAvatarBeforeUpload"
                        :auto-upload="false"
                        accept="image/gif, image/jpg, image/jpeg, image/bmp, image/png, image/webp"
                    >
                        <el-image :src="state.adminInfo.avatar" class="avatar">
                            <template #error>
                                <div class="image-slot">
                                    <Icon size="30" color="#c0c4cc" name="el-icon-Picture" />
                                </div>
                            </template>
                        </el-image>
                    </el-upload>
                    <div class="admin-info-base">
                        <div class="admin-nickname">{{ state.adminInfo.nickname }}</div>
                        <div class="admin-other">
                            <div>管理员最后登录时间： {{ state.adminInfo.lastlogintime }}</div>
                        </div>
                    </div>
                    <div class="admin-info-form">
                        <el-form
                            @keyup.enter="onSubmit(formRef)"
                            :key="state.formKey"
                            label-position="top"
                            :rules="rules"
                            ref="formRef"
                            :model="state.adminInfo"
                        >
                            <el-form-item label="管理员账户名">
                                <el-input disabled v-model="state.adminInfo.username"></el-input>
                            </el-form-item>
                            <el-form-item label="管理员昵称" prop="nickname">
                                <el-input placeholder="请输入管理员昵称" v-model="state.adminInfo.nickname"></el-input>
                            </el-form-item>
                            <el-form-item label="管理员邮箱" prop="email">
                                <el-input
                                    placeholder="请输入邮箱地址"
                                    v-model="state.adminInfo.email"
                                ></el-input>
                            </el-form-item>
                            <el-form-item label="手机号码" prop="mobile">
                                <el-input
                                    placeholder="请输入手机号码"
                                    v-model="state.adminInfo.mobile"
                                ></el-input>
                            </el-form-item>
                            <el-form-item label="座右铭" prop="motto">
                                <el-input
                                    @keyup.enter.stop=""
                                    @keyup.ctrl.enter="onSubmit(formRef)"
                                    placeholder="这个人很懒什么都没有写"
                                    type="textarea"
                                    v-model="state.adminInfo.motto"
                                ></el-input>
                            </el-form-item>
                            <el-form-item label="新密码" prop="password">
                                <el-input
                                    type="password"
                                    placeholder="未修改，请留空"
                                    v-model="state.adminInfo.password"
                                ></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" :loading="state.buttonLoading" @click="onSubmit(formRef)">提交</el-button>
                                <el-button @click="onResetForm(formRef)">重置</el-button>
                            </el-form-item>
                        </el-form>
                    </div>
                </div>
            </el-col>
            <el-col v-loading="state.logLoading" :xs="24" :sm="24" :md="24" :lg="12">
                <el-card header="操作日志" shadow="never">
                    <el-timeline>
                        <el-timeline-item v-for="(item, idx) in state.log" :key="idx" size="large" :timestamp="item.createtime">
                            {{ item.title }}
                        </el-timeline-item>
                    </el-timeline>
                    <el-pagination
                        :currentPage="state.logCurrentPage"
                        :page-size="state.logPageSize"
                        :page-sizes="[12, 22, 52, 100]"
                        background
                        layout="prev, next, jumper"
                        :total="state.logTotal"
                        @size-change="onLogSizeChange"
                        @current-change="onLogCurrentChange"
                    ></el-pagination>
                </el-card>
            </el-col>
        </el-row>
    </div>
</template>

<script setup lang="ts">
import { ref, reactive } from 'vue'
// import { index, log, postData } from '@/api/backend/routine/AdminInfo'
import { ElForm, FormItemRule } from 'element-plus'
import { onResetForm } from '@/utils/common'
import { uuid } from '@/utils/random'
import { fileUpload } from '@/api/common'
import { useAdminInfo } from '@/stores/adminInfo'

const formRef = ref<InstanceType<typeof ElForm>>()

const adminInfoStore = useAdminInfo()

const state: {
    adminInfo: anyObj
    formKey: string
    buttonLoading: boolean
    log: {
        title: string
        createtime: string
        url: string
    }[]
    logFilter: anyObj
    logCurrentPage: number
    logPageSize: number
    logTotal: number
    logLoading: boolean
} = reactive({
    adminInfo: {},
    formKey: uuid(),
    buttonLoading: false,
    log: [],
    logFilter: {
        limit: 12,
    },
    logCurrentPage: 1,
    logPageSize: 12,
    logTotal: 100,
    logLoading: true,
})

// index().then((res) => {
//     state.adminInfo = res.data.info
//     // 重新渲染表单以记录初始值
//     state.formKey = uuid()

//     // 管理员日志加载，加筛选防止超管读取到其他管理员的日志记录
//     state.logFilter.search = [
//         {
//             field: 'admin_id',
//             val: res.data.info.id,
//             operator: '=',
//         },
//     ]
//     getLog()
// })

const getLog = () => {
    // log(state.logFilter)
    //     .then((res:any) => {
    //         state.log = res.data.list
    //         state.logTotal = res.data.total
    //         state.logLoading = false
    //     })
    //     .catch(() => {
    //         state.logLoading = false
    //     })
}

const onLogSizeChange = (limit: number) => {
    state.logPageSize = limit
    state.logFilter.limit = limit
    getLog()
}

const onLogCurrentChange = (page: number) => {
    state.logCurrentPage = page
    state.logFilter.page = page
    getLog()
}

const rules: Partial<Record<string, FormItemRule[]>> = reactive({
    nickname: [],
    email: [],
    mobile: [],
    password: [],
})

const onAvatarBeforeUpload = (file: any) => {
    let fd = new FormData()
    fd.append('file', file.raw)
    fileUpload(fd).then((res) => {
        if (res.code == 1) {
            // postData({
            //     id: state.adminInfo.id,
            //     avatar: res.data.file.url,
            // }).then(() => {
            //     adminInfoStore.dataFill({ ...adminInfoStore.$state, avatar: res.data.file.full_url })
            //     state.adminInfo.avatar = res.data.file.full_url
            // })
        }
    })
}

const onSubmit = (formEl: InstanceType<typeof ElForm> | undefined) => {
    if (!formEl) return
    formEl.validate((valid) => {
        if (valid) {
            let data = { ...state.adminInfo }
            delete data.lastlogintime
            delete data.username
            delete data.avatar
            state.buttonLoading = true
            // postData(data)
            //     .then(() => {
            //         adminInfoStore.dataFill({ ...adminInfoStore.$state, nickname: state.adminInfo.nickname })
            //         state.buttonLoading = false
            //     })
            //     .catch(() => {
            //         state.buttonLoading = false
            //     })
        }
    })
}
</script>

<script lang="ts">
import { defineComponent } from 'vue'
export default defineComponent({
    name: 'routine/adminInfo',
})
</script>

<style scoped lang="scss">
.admin-info {
    background-color: var(--ba-bg-color-overlay);
    border-radius: var(--el-border-radius-base);
    border-top: 3px solid #409eff;
    .avatar-uploader {
        display: flex;
        align-items: center;
        justify-content: center;
        position: relative;
        margin: 60px auto 10px auto;
        border-radius: 50%;
        box-shadow: var(--el-box-shadow-light);
        border: 1px dashed var(--el-border-color);
        cursor: pointer;
        overflow: hidden;
        width: 110px;
        height: 110px;
    }
    .avatar-uploader:hover {
        border-color: var(--el-color-primary);
    }
    .avatar {
        width: 110px;
        height: 110px;
        display: block;
    }
    .image-slot {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100%;
    }
    .admin-info-base {
        .admin-nickname {
            font-size: 22px;
            color: var(--el-text-color-primary);
            text-align: center;
            padding: 8px 0;
        }
        .admin-other {
            color: var(--el-text-color-regular);
            font-size: 14px;
            text-align: center;
            line-height: 20px;
        }
    }
    .admin-info-form {
        padding: 30px;
    }
}
.el-card :deep(.el-timeline-item__icon) {
    font-size: 10px;
}
@media screen and (max-width: 1200px) {
    .lg-mb-20 {
        margin-bottom: 20px;
    }
}
</style>
