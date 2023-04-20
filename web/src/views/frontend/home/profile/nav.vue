<template>
    <nav>
        <el-row>
            <el-col :span="24" class="container">
                <div class="logo">
                    <img src="@/assets/images/logo.png" alt=""><!-- Logo -->
                </div>
                <div class="mobile-bar"><span></span></div>
                <ul class="nav-menu">
                    <li><router-link  :to="{ path: '/'}" >Home</router-link></li>
                    <li><router-link  :to="{ path: '/#about'}">About</router-link></li>
                    <li><router-link  :to="{ path: '/#hobby'}">Hobby</router-link></li>
                    <li><router-link  :to="{ path: '/#blog'}">Blog</router-link></li>
                    <li><router-link  :to="{ path: '/#contact'}">Contact</router-link></li>
                </ul>
            </el-col>
        </el-row>
    </nav>
</template>

<script setup lang="ts">

</script>

<style scoped lang="scss">
@import "@/styles/homePage.scss";



</style>