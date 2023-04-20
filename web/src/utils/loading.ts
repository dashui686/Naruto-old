import { nextTick } from 'vue'
import '@/styles/loading.scss'

export const loading = {
    forntend:()=>{
        const bodys: Element = document.body
        const div = document.createElement('div')
        div.className = 'preloader-loding'
        div.innerHTML = `
            <div class="pre-container">
                <div class="spinner">
                    <div class="double-bounce1"></div>
                    <div class="double-bounce2"></div>
                </div>
            </div>
        `
        bodys.insertBefore(div, bodys.childNodes[0])
    },
    backend:()=>{
        const bodys: Element = document.body
        const div = document.createElement('div')
        div.className = 'block-loading'
        div.innerHTML = `
            <div class="block-loading-box">
                <div class="block-loading-box-warp">
                    <div class="block-loading-box-item"></div>
                    <div class="block-loading-box-item"></div>
                    <div class="block-loading-box-item"></div>
                    <div class="block-loading-box-item"></div>
                    <div class="block-loading-box-item"></div>
                    <div class="block-loading-box-item"></div>
                    <div class="block-loading-box-item"></div>
                    <div class="block-loading-box-item"></div>
                    <div class="block-loading-box-item"></div>
                </div>
            </div>
        `
        bodys.insertBefore(div, bodys.childNodes[0])
    },
    show: (type:string) => {
        if("backend" == type){
            loading.backend();
        }else{
            loading.forntend();
        }
    },
    hide: (type:string) => {

        if("backend" == type){
            nextTick(() => {
                setTimeout(() => {
                    const el = document.querySelector('.block-loading')
                    el && el.parentNode?.removeChild(el)
                }, 1000)
            })
        }else{

            nextTick(() => {
                const el = document.querySelector('.preloader-loding')
                el && el.parentNode?.removeChild(el)
            })

        }
      
    },
}
