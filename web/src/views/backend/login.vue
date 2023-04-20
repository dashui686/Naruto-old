<template>
    <div class="loginPage" id="bubble">
        <div class="login">
            <div class="login-header">
                <img src="@/assets/login-header.png" />
            </div>
            <div class="login-form">
                <img src="@/assets/avatar.png"/>
                <el-form :model="form" ref="formRef" :rules="rules" >
                    <el-form-item prop="username">
                        <el-input ref="usernameRef" v-model="form.username" placeholder="请输入用户名">
                            <template #prefix>
                                <Icon name="el-icon-User" class="form-item-icon" size="16" color="var(--el-input-icon-color)" />
                            </template>
                        </el-input>
                    </el-form-item>
                    <el-form-item  prop="password">
                        <el-input ref="passwordRef" v-model="form.password" placeholder="请输入密码">
                            <template #prefix>
                                <Icon name="el-icon-Unlock" class="form-item-icon" size="16" color="var(--el-input-icon-color)" />
                            </template>
                        </el-input>
                    </el-form-item>
                    <el-form-item prop="captcha">
                        <el-row>
                            <el-col :span="15">
                                <el-input ref="captchaRef" v-model="form.captcha" placeholder="请输入验证码">
                                    <template #prefix>
                                        <Icon name="el-icon-More" class="form-item-icon" size="16" color="var(--el-input-icon-color)" />
                                    </template>
                                </el-input>
                            </el-col>
                            <el-col :offset="1" :span="8">
                                <img src="@/assets/captcha.png" />
                            </el-col>
                        </el-row>
                        
                    </el-form-item>
                    <el-form-item>
                        <el-checkbox v-model="form.keep" label="记住我" />
                    </el-form-item>
                    <el-form-item>
                        <el-button class="submit" type="primary" @click="onSubmit(formRef)">登录</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
import { onMounted, onBeforeUnmount, reactive, ref, nextTick } from 'vue'
import type { ElForm, ElInput } from 'element-plus'
import { ElNotification } from 'element-plus'
import { useConfig } from '@/stores/config'
import { useAdminInfo } from '@/stores/adminInfo'
import { login } from '@/api/backend/index'
import router from '@/router'
import { uuid } from '@/utils/random'

import type { FormInstance, FormRules } from 'element-plus'
var timer: NodeJS.Timer

const config = useConfig()
const adminInfo = useAdminInfo()

const state = reactive({
    showCaptcha: true,
    captchaId: uuid(),
})

const onChangeCaptcha = () => {
    form.captcha = ''
    state.captchaId = uuid()
}

const formRef = ref<InstanceType<typeof ElForm>>()
const usernameRef = ref<InstanceType<typeof ElInput>>()
const passwordRef = ref<InstanceType<typeof ElInput>>()
const captchaRef = ref<InstanceType<typeof ElInput>>()
const form = reactive({
    username: '',
    password: '',
    captcha: '',
    keep: false,
    loading: false,
    captcha_id: '',
})


// 表单验证规则
const rules = reactive<FormRules>({
    name: [
        { required: true, message: 'Please input Activity name', trigger: 'blur' },
        { min: 3, max: 5, message: 'Length should be 3 to 5', trigger: 'blur' },
    ],
    region: [
        {
        required: true,
        message: 'Please select Activity zone',
        trigger: 'change',
        },
    ],
    count: [
        {
        required: true,
        message: 'Please select Activity count',
        trigger: 'change',
        },
    ],
})

const focusInput = () => {
    if (form.username === '') {
        usernameRef.value!.focus()
    } else if (form.password === '') {
        passwordRef.value!.focus()
    } else if (form.captcha === '') {
        captchaRef.value!.focus()
    }
}

onMounted(() => {
    login('get')
        .then((res) => {

            // state.showCaptcha = res.data.captcha
            nextTick(() => {
                focusInput()
            })
        })
        .catch((err) => {
            console.log(err)
        })
})

onBeforeUnmount(() => {
    clearTimeout(timer)
})

const onSubmit = (formEl: InstanceType<typeof ElForm> | undefined) => {

    if (!formEl) return
    formEl.validate((valid) => {
        if (valid) {
            form.loading = true
            form.captcha_id = state.captchaId
            login('post', form)
                .then((res) => {
                    form.loading = false
                    adminInfo.dataFill(res.data.userInfo)
                    ElNotification({
                        message: res.msg,
                        type: 'success',
                    })
                    router.push({ path: res.data.routePath })
                })
                .catch(() => {
                    onChangeCaptcha()
                    form.loading = false
                })
        } else {
            onChangeCaptcha()
            return false
        }
    })
}
</script>

<style scoped lang="scss">


.loginPage{
    height: 100%;
    background-image: url('https://lidashui.oss-cn-beijing.aliyuncs.com/bg.svg');
    background-repeat: no-repeat;
    background-position: center center;
    background-size: cover;
    width: 100%;
    height: 100%;
    position: relative;
    display: flex;
    align-items: center;
    justify-content: center;
}

.login{
    width: 400px;
    overflow: hidden;
    box-shadow: 0px 0px 5px #bababa;
    background-color: white;
    border-radius: 15px;
}


.login-header{
    background: #ccccff;
}
.login-header > img{
    display: block;
    width: 400px;
}
.login-form{
    position: relative;
}
.el-form{
    position: relative;
    padding: 70px 50px 50px 50px;
}


.login-form > img{
    display: block;
    position: absolute;
    height: 100px;
    width: 100px;
    border-radius: 50%;
    border: 4px solid var(--ba-bg-color-overlay);
    top: -50px;
    right: calc(50% - 50px);
    z-index: 2;
    user-select: none;
    border: 5px solid white;
}

.el-form img{
    width: 100%;
}


.submit{
    width: 100%;
    border-radius: 50px;
    padding: 18px 0;
}


@media only screen and (max-width: 479px) {
    .login{
        width: 300px;
    }

    .el-form{
        position: relative;
        padding: 70px 15px 15px 15px;
    }
}
</style>
