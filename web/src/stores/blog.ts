import { reactive } from 'vue'
import { defineStore } from 'pinia'

export const blogConfig = defineStore(
    'blog',
    () => {
       const config = reactive({
        showAdd:false,
        dialogFormVisible:false,
        formWidth:"140px"
       })
 
       const formValue = reactive({
            id:undefined,
            title:"",
            content:"",
            cover:"",
            description:"",
            type:[],
            tag:[],
            disable:1,
            top:0,
            sort:0
       })

       function resetFormValue(){
            const defaultValue = {
                id:undefined,
                title:"",
                content:"",
                cover:"",
                description:"",
                type:[],
                tag:[],
                disable:1,
                top:0,
                sort:0
           }
            Object.assign(formValue, defaultValue);
        }



        function changeShowAdd() {
            config.showAdd =!config.showAdd; 
        }

        function changeDialogForm(){
            config.dialogFormVisible = !config.dialogFormVisible; 
        
        }
        
        

        return { config,formValue,changeShowAdd,changeDialogForm,resetFormValue }
    },
    {
        persist: {
            key: "blog",
        },
    }
)
