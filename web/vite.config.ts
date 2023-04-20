import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// 自动导入vue中hook reactive ref等
import AutoImport from "unplugin-auto-import/vite"
//自动导入ui-组件 比如说ant-design-vue  element-plus等
import Components from 'unplugin-vue-components/vite';
 // 配置@别名
 import { resolve } from "path"; 

// vue3 stup 自定义组件名 <scripte langt='ts' setup name="XXX">
import VueSetupExtend from 'vite-plugin-vue-setup-extend'
//element
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'
// 代码提亮
import {prismjsPlugin} from 'vite-plugin-prismjs';


const pathSrc = resolve(__dirname, 'src')

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    prismjsPlugin({
      languages: ['json','java','js','html','ts','sh','sql'],
      // languages: ['json'],
    }),
    VueSetupExtend(),
    AutoImport({
      // Auto import functions from Vue, e.g. ref, reactive, toRef...
      // 自动导入 Vue 相关函数，如：ref, reactive, toRef 等
      imports: ['vue', 'vue-router'],
      // Auto import functions from Element Plus, e.g. ElMessage, ElMessageBox... (with style)
      // 自动导入 Element Plus 相关函数，如：ElMessage, ElMessageBox... (带样式)
      resolvers: [
        ElementPlusResolver(),
      ],
      
      //element
      dts: "src/auto-import.d.ts",
    }),
		Components({
			// 引入组件的,包括自定义组件
      // 存放的位置
      dts: "src/components.d.ts",
      //element
      resolvers: [
        ElementPlusResolver(),
      ],
		}),

  
  ],
   // ↓解析配置
   resolve: {
    // ↓路径别名
    alias: {
      "@": pathSrc
    }
  },
  // 服务
  server: {
    host: '127.0.0.1',
    port: 80,
    open: true,
    // proxy: proxy,
},
})
