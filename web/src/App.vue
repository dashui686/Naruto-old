<script setup lang="ts">
import { onMounted, watch } from 'vue'
// import iconfontInit from '@/utils/iconfont'
import { useRoute } from 'vue-router'
import { setTitleFromRoute } from '@/utils/common'
import { useConfig } from '@/stores/config'

const config = useConfig()
const route = useRoute()

  onMounted(() => {
    // iconfontInit()

    // Modules onMounted mark, Please do not remove.
})

// 监听路由变化时更新浏览器标题
watch(
    () => route.path,
    () => {
        setTitleFromRoute()
    }
)
</script>

<template>
  <router-view class="routerView"></router-view>
</template>

<style scoped>
.routerView{
  height: 100%;
  width: 100%;
}
</style>
