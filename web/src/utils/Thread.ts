export const  setTimeOutAsync=async (e:any,timeout:number)=>{
    return await new Promise(resolve=>{
        setTimeout(()=>{
            return resolve(e);
        },timeout)
    })
}
