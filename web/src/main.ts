
import App from './App.vue'
 //routes
import router from "./router/index";
//pinia
import pinia from '@/stores/index' 
// 样式
import '@/styles/index.scss'
import 'element-plus/dist/index.css'
// icon
import { loadCss, registerIcons } from '@/utils/common'
// mitt
import mitt from 'mitt'
//引入echarts
import * as echarts from 'echarts';
//  引入 markdownEditor
// import VueMarkdownEditor from '@/utils/markDown/mdEditor';
// import VueMarkdownPreview from '@/utils/markDown/mdPreview';

import {VueMarkdownEditor,VueMarkdownPreview} from '@/utils/markDown';

loadCss("//at.alicdn.com/t/c/font_3985254_zgokuvy04c.css");

const app = createApp(App)

//routes 
app.use(router)  
//pinia
app.use(pinia)  
//放入全局
app.config.globalProperties.$echarts = echarts

registerIcons(app) // icons
    // modules start mark, Please do not remove.
app.config.globalProperties.eventBus = mitt();

// makdown
app.use(VueMarkdownEditor);
app.use(VueMarkdownPreview);

app.mount('#app')
