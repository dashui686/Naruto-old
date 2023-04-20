<template>
    <section class="contact-section spad" id="contact">
        <div class="container">
            <div class="section-title">
                <h2>保持联系</h2>
                <p>留个联系方式，可以互相帮助代码人代码魂！留个好友位，方便内推讨论</p>
            </div>
            <el-row>
                <el-col :md="10">
                    <ul class="con-info">
                        <li>
                            <i class="iconfont icon-dianhua"></i> 
                            <span>电话</span>
                            <p>+1 (123) 456-7890</p>
                        </li>
                        <li>
                            <i class="iconfont icon-youjian"></i> 
                            <span>电子邮件</span>
                            <p>li1327674904@163.com</p>
                        </li>
                        <li>
                            <i class="iconfont icon-daohangdizhi"></i> 
                            <span>地址</span>
                            <p>A902, Crosswinds Apt, Western Road, <br>Brighton, East Sussex, 巴斯</p>
                        </li>
                    </ul>
                </el-col>
                <el-col :md="14" class="contact-left">
                    <div id="form-chack"></div>
                    <!-- Contact Form -->
                    <form action="" id="contact-form" method="POST">
                        <input type="text" name="name" id="name"  placeholder="你的名字*">
                        <input type="email" name="email" id="email"  placeholder="你的邮件*">
                        <div class="send-btn-div">
                            <textarea id="massage" name="massage"  placeholder="您的按摩*"></textarea>
                            <button  class="send-btn"><i class="iconfont icon-zhifeiji"></i> </button>
                        </div>
                    </form>
                </el-col>
            </el-row>
        </div>
    </section>
</template>

<script setup lang="ts">

</script>

<style scoped lang="scss">
@import "@/styles/homePage.scss";

</style>