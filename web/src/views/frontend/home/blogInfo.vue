<template>
    <section>
        <Nav  class="subpage-nav" />
            <section class="single-section spad">
                <div class="container">
                    <div
                        v-for="anchor in titles"
                        :style="{ padding: `10px 0 10px ${anchor.indent * 20}px` }"
                        @click="handleAnchorClick(anchor)"
                        >
                        <a style="cursor: pointer">{{ anchor.title }}</a>
                    </div>
                    <el-row :offset="2" class="single-blogpost">
                        <el-col :md="14" :sm="12" class="no-pad by-admin">
                            <h5> <el-icon><UserFilled /></el-icon>由 {{ data.blog.createBy }} 发布 |  <el-icon><Timer /></el-icon> {{ data.blog.createTime }} | <el-icon><Comment /></el-icon> {{ data.comments?data.comments.length:0 }} 评论</h5>
                        </el-col>
                        <el-col :md="10" :sm="12" class=" no-pad single-social">
                            <a href="https://www.jq22.com/demo/jquerydyweb201908160049/single-blog.html#"><i class="iconfont icon-chakan"></i> {{ data.blog.browse }}</a>
                            <a href="https://www.jq22.com/demo/jquerydyweb201908160049/single-blog.html#"><i class="iconfont icon-dianzan"></i> {{ data.blog.praise }}</a>
                            <!-- <a href="https://www.jq22.com/demo/jquerydyweb201908160049/single-blog.html#"><i class="fa fa-tumblr"></i> 195</a>
                            <a href="https://www.jq22.com/demo/jquerydyweb201908160049/single-blog.html#"><i class="fa fa-twitter"></i> 65</a> -->
                        </el-col>
                        <div class="post-img">
                            <el-image style="width: 100%;height: 500px;" :src="data.blog.cover" fit="cover" />
                        </div>	
                        <!-- <h2 class="title-heading">{{ data.blog.title }}</h2> -->
                        
                        <v-md-editor 
                            ref="preview"
                            v-model="data.content"
                            mode="preview"
                        ></v-md-editor>
                        <!-- <v-md-preview-html :html="data.content" preview-class="vuepress-markdown-body"></v-md-preview-html> -->
                        <!-- Post Comments -->
                        <div class="comment">
                            <h3>留言</h3>
                            <ul class="comment-list">
                                <li v-for="item in data.comments" class="reply-has">
                                    <img src="@/assets/images/comment-1.jpg" alt="">
                                    <div class="comment-info">
                                        <h4>{{ item.operator }}</h4>
                                        <p>{{ item.message }}</p>
                                        <el-link  class="reply"  :underline="false">Reply</el-link>
                                    </div>
                                    <ul v-if="data.comments.children" class="reply-comment-list" >
                                        <li v-for="reitem in data.comments.children">
                                            <img src="@/assets/images/comment-1.jpg" alt="">
                                            <div class="comment-info">
                                                <h4>Mary R. Peterson</h4>
                                                <p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit.</p>
                                                <a class="reply" href="https://www.jq22.com/demo/jquerydyweb201908160049/single-blog.html#"> Reply </a>
                                            </div>
                                        </li>
                                        <li>
                                            <img src="@/assets/images/comment-1.jpg" alt="">
                                            <div class="comment-info">
                                                <h4>Mary R. Peterson</h4>
                                                <p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit.</p>
                                                <a class="reply" href="https://www.jq22.com/demo/jquerydyweb201908160049/single-blog.html#"> Reply </a>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                            <!-- Comment Form -->
                            <form :md="12" class="comment-form send-message">
                                <h3 class="subtitle">Leave a Reply</h3>
                                <el-row>
                                    <!--Name-->
                                    <el-col :md="12">
                                        <input type="text" placeholder="Name">
                                    </el-col>
                                    <!--Email-->
                                    <el-col :md="12">
                                        <input type="text" placeholder="Email">
                                    </el-col>
                                    <!--Message-->
                                    <el-col :md="24">
                                        <textarea name="con_message" placeholder="Message" rows="8"></textarea>
                                    </el-col>
                                </el-row>
                                    <button class="site-button" type="submit">SEND A MESSAGE</button>
                            </form>
                        </div>
                    </el-row>		
                </div>
            </section>
        <Footer />
    </section>
</template>

<script setup lang="ts">
import Footer from './profile/footer.vue';
import Nav from './profile/nav.vue';
import { useRoute } from 'vue-router';
import { blog } from '@/api/frontend/homePage';
import { generateCodeFrame } from '@vue/shared';
import { UserFilled,Comment,Timer } from '@element-plus/icons-vue';
import {ComponentInternalInstance} from "vue"

const {proxy} = getCurrentInstance() as ComponentInternalInstance;
const route = useRoute();
const data =ref<any>({
    blog:{
        browse: 0,
        cover: "",
        createBy: "",
        createTime: "",
        description: "",
        disable: 1,
        id: 0,
        praise: 0,
        sort: 0,
        title: "",
        top: 0
    },
    comments:[],
    content:"",
});

const titles = ref<any>([]);

onBeforeMount(()=>{
    blog(route.params.id).then(res=>{
        data.value = res.data;
    })
})

onMounted(()=>{
    console.log();

    let preview = proxy!.$refs!.preview as any;
    // console.log(preview.$el.querySelectorAll("h1,h2,h3,h4,h5,h6"))
    console.log(preview.$el.querySelectorAll(".vuepress-markdown-body")[0].querySelectorAll("h1"))
    // console.log(preview.$el.getElementByclassName("vuepress-markdown-body"))
    const anchors = preview.$el.querySelectorAll('h1,h2,h3,h4,h5,h6');
    titles.value = Array.from(anchors).filter((title:any) => !!title.innerText.trim());

    if (!titles.value.length) {
      titles.value = [];
      return;
    }

    const hTags = Array.from(new Set(titles.value.map((title:any) => title.tagName))).sort();

    titles.value = titles.value.map((el:any) => ({
        title: el.innerText,
        lineIndex: el.getAttribute('data-v-md-line'),
        indent: hTags.indexOf(el.tagName),
    }));
})



const handleAnchorClick=(anchor:any)=> {
      const { preview } = proxy!.$refs as any;
      const { lineIndex } = anchor;

      const heading = preview.$el.querySelector(`[data-v-md-line="${lineIndex}"]`);

      if (heading) {
        preview.scrollToTarget({
          target: heading,
          scrollContainer: window,
          top: 60,
        });
      }
    }

// <li class="reply-has">
//                                     <img src="@/assets/images/comment-1.jpg" alt="">
//                                     <div class="comment-info">
//                                         <h4>Mary R. Peterson</h4>
//                                         <p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit.</p>
//                                         <a class="reply" href="https://www.jq22.com/demo/jquerydyweb201908160049/single-blog.html#"> Reply </a>
//                                     </div>
//                                     <ul class="reply-comment-list">
//                                         <li>
//                                             <img src="@/assets/images/comment-1.jpg" alt="">
//                                             <div class="comment-info">
//                                                 <h4>Mary R. Peterson</h4>
//                                                 <p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit.</p>
//                                                 <a class="reply" href="https://www.jq22.com/demo/jquerydyweb201908160049/single-blog.html#"> Reply </a>
//                                             </div>
//                                         </li>
//                                         <li>
//                                             <img src="@/assets/images/comment-1.jpg" alt="">
//                                             <div class="comment-info">
//                                                 <h4>Mary R. Peterson</h4>
//                                                 <p>This is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit.</p>
//                                                 <a class="reply" href="https://www.jq22.com/demo/jquerydyweb201908160049/single-blog.html#"> Reply </a>
//                                             </div>
//                                         </li>
//                                     </ul>
//                                 </li>


</script>

<style scoped lang="scss">
@import "@/styles/homePage.scss";

</style>