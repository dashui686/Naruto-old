<template>
    <section class="blog-section spad" id="blog">
        <div class="container">
            <div class="section-title">
				<h2>最新博客</h2>
                <el-image />
				<p>出乎意料的是，舒适感并不明显。表妹们分分钟高兴起来。天才已经看尽激怒了春天。</p>
			</div>
            <el-row>
                <el-col :md="8" class="blog-item"
                    v-for="item in blogs as any"
                >

                    <el-skeleton
                        :loading="loading"
                        animated
                        :throttle="500"
                    >
                        <template #template>

                            <div>
                                <el-skeleton-item variant="image" style="width: 100%; height: 224px" />
                                <div class="blog-item-text">
                                    <h3>
                                        <el-skeleton-item variant="h3" style="width: 50%" />
                                    </h3>
                                    <p><el-skeleton-item variant="text" /></p>
                                    <p><el-skeleton-item variant="text" /></p>
                                    <p><el-skeleton-item variant="text" /></p>
                                </div>
                            </div>
                            <!-- <div>
                                <img src="@/assets/images/blog1.jpg" alt="">
                                <div class="blog-item-text">
                                    <h3>出乎意料有要求不怎么样</h3>
                                    <p>快六盲灵出爆。完全对家具的沮丧决定了我的依赖。加短水场肥。</p>
                                    <h5>2017 年 2 月 7 日 / 由管理员发布</h5>
                                </div>
                            </div> -->
                        </template>
                        <template #default>
                            <div>
                                <el-image :src="'https://lidashui.oss-cn-beijing.aliyuncs.com/blogConver.png'">
                                    <template #error>
                                        <div class="image-slot">
                                            <el-icon><icon-picture /></el-icon>
                                        </div>
                                    </template>
                                </el-image>
                                <div class="blog-item-text">
                                    <h3>{{item.title}}</h3>
                                    <p>{{ item.description }}</p>
                                    <h5>{{ item.createTime }} / 由{{item.createBy}}发布</h5>
                                </div>
                            </div>

                        </template>
                    </el-skeleton>
                    
                </el-col>
                <!-- <el-col :md="8" class="blog-item">
                    <div>
                        <img src="@/assets/images/blog1.jpg" alt="">
                        <div class="blog-item-text">
                            <h3>出乎意料有要求不怎么样</h3>
                            <p>快六盲灵出爆。完全对家具的沮丧决定了我的依赖。加短水场肥。</p>
                            <h5>2017 年 2 月 7 日 / 由管理员发布</h5>
                        </div>
                    </div>
                </el-col>
                <el-col :md="8" class="blog-item">
                    <div>
                        <img src="@/assets/images/blog1.jpg" alt="">
                        <div class="blog-item-text">
                            <h3>出乎意料有要求不怎么样</h3>
                            <p>快六盲灵出爆。完全对家具的沮丧决定了我的依赖。加短水场肥。</p>
                            <h5>2017 年 2 月 7 日 / 由管理员发布</h5>
                        </div>
                    </div>
                </el-col> -->
            </el-row>
            <div class="text-center mt20">
                <router-link to="/blogPage" class="site-button" >LOAD MORE.</router-link>
			</div>
        </div>
    </section>
</template>

<script setup lang="ts">
import { Picture as IconPicture } from '@element-plus/icons-vue'
const loading = ref(true);
const props = defineProps({
    blogs:{
        type: Array
    }
});

nextTick(()=>{
    loading.value = false;
})
const {blogs} = toRefs(props);

</script>

<style scoped lang="scss">
@import "@/styles/homePage.scss";



.demo-image__error .block {
  padding: 30px 0;
  text-align: center;
  border-right: solid 1px var(--el-border-color);
  display: inline-block;
  width: 49%;
  box-sizing: border-box;
  vertical-align: top;
}
.demo-image__error .demonstration {
  display: block;
  color: var(--el-text-color-secondary);
  font-size: 14px;
  margin-bottom: 20px;
}
.demo-image__error .el-image {
  padding: 0 5px;
  width: 100%;
  max-height: 300px;
  width: 100%;
  height: 300px;
}

.demo-image__error .image-slot {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  background: var(--el-fill-color-light);
  color: var(--el-text-color-secondary);
  font-size: 30px;
}
.demo-image__error .image-slot .el-icon {
  font-size: 30px;
}

</style>