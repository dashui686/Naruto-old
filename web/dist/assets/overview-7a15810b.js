import{p as B,h as G,a7 as z,a as N,a8 as R,U as A,_ as V}from"./index-1ab2f843.js";import{h as D,Y as F,y as L,r as S,ap as U,B as q,ae as E,t as d,Z as M,p as b,l as T,q as t,K as a,o as r,Q as l,V as J,J as K,k as o,R as c,n as O}from"./vue-cc6aeb83.js";import{i as P}from"./echarts-d2519496.js";const Q={class:"user-views"},Y={class:"card-header"},Z={class:"overview-userinfo"},j={class:"user-avatar"},H=["src"],W={class:"user-avatar-icons"},X={class:"user-data"},x={class:"welcome-words"},ee=D({__name:"overview",setup(te){const{t:p}=B(),v=F(),i=G(),f=L(),n=S({days:[],score:[],money:[],charts:[]}),k=()=>{const e=P(f.value),s={grid:{top:10,right:0,bottom:20,left:50},xAxis:{data:n.days},yAxis:{},legend:{data:[p("Integral"),p("Balance")]},series:[{name:p("Integral"),data:n.score,type:"line",smooth:!0,show:!1,color:"#f56c6c",emphasis:{label:{show:!0}},areaStyle:{}},{name:p("Balance"),data:n.money,type:"line",smooth:!0,show:!1,color:"#409eff",emphasis:{label:{show:!0}},areaStyle:{opacity:.4}}]};e.setOption(s),n.charts.push(e)},_=()=>{O(()=>{for(const e in n.charts)n.charts[e].resize()})};return U(()=>{_()}),q(()=>{z().then(e=>{n.days=e.data.days,n.score=e.data.score,n.money=e.data.money,k()}),N(window,"resize",_)}),E(()=>{for(const e in n.charts)n.charts[e].dispose()}),(e,s)=>{const C=d("el-button"),h=d("Icon"),w=d("el-tooltip"),u=d("el-col"),y=d("el-link"),g=d("el-row"),$=d("el-card"),I=M("blur");return b(),T("div",Q,[t($,{class:"user-views-card",shadow:"hover"},{header:a(()=>[r("div",Y,[r("span",null,l(e.$t("user.account.overview.Account information")),1),J((b(),K(C,{onClick:s[0]||(s[0]=m=>o(v).push({name:"account/profile"})),type:"info",plain:""},{default:a(()=>[c(l(e.$t("user.account.overview.personal data")),1)]),_:1})),[[I]])])]),default:a(()=>[r("div",Z,[r("div",j,[r("img",{src:o(i).avatar,alt:""},null,8,H),r("div",W,[r("div",{onClick:s[1]||(s[1]=m=>o(v).push({name:"account/profile"})),class:"avatar-icon-item"},[t(w,{effect:"light",placement:"right",content:(o(i).mobile?e.$t("user.account.overview.Filled in"):e.$t("user.account.overview.Not filled in"))+e.$t("user.account.overview.mobile")},{default:a(()=>[t(h,{name:"fa fa-tablet",size:"16",color:o(i).mobile?"var(--el-color-primary)":"var(--el-text-color-secondary)"},null,8,["color"])]),_:1},8,["content"])]),r("div",{onClick:s[2]||(s[2]=m=>o(v).push({name:"account/profile"})),class:"avatar-icon-item"},[t(w,{effect:"light",placement:"right",content:(o(i).email?e.$t("user.account.overview.Filled in"):e.$t("user.account.overview.Not filled in"))+e.$t("user.account.overview.email")},{default:a(()=>[t(h,{name:"fa fa-envelope-square",size:"14",color:o(i).email?"var(--el-color-primary)":"var(--el-text-color-secondary)"},null,8,["color"])]),_:1},8,["content"])])])]),r("div",X,[r("div",x,l(o(i).nickname+e.$t("utils.comma")+o(R)()),1),t(g,{class:"data-item"},{default:a(()=>[t(u,{span:4},{default:a(()=>[c(l(e.$t("Integral")),1)]),_:1}),t(u,{span:8},{default:a(()=>[t(y,{onClick:s[3]||(s[3]=m=>o(v).push({name:"account/integral"})),type:"primary"},{default:a(()=>[c(l(o(i).score),1)]),_:1})]),_:1}),t(u,{span:4},{default:a(()=>[c(l(e.$t("Balance")),1)]),_:1}),t(u,{span:8},{default:a(()=>[t(y,{onClick:s[4]||(s[4]=m=>o(v).push({name:"account/balance"})),type:"primary"},{default:a(()=>[c(l(o(i).money),1)]),_:1})]),_:1})]),_:1}),t(g,{class:"data-item"},{default:a(()=>[t(u,{class:"lastlogin title",span:4},{default:a(()=>[c(l(e.$t("user.account.overview.Last login")),1)]),_:1}),t(u,{class:"lastlogin value",span:8},{default:a(()=>[c(l(o(A)(o(i).lastlogintime)),1)]),_:1}),t(u,{class:"lastip",span:4},{default:a(()=>[c(l(e.$t("user.account.overview.Last login IP")),1)]),_:1}),t(u,{class:"lastip",span:8},{default:a(()=>[c(l(o(i).lastloginip),1)]),_:1})]),_:1})])])]),_:1}),t($,{class:"user-views-card",shadow:"hover",header:e.$t("user.account.overview.Growth statistics")},{default:a(()=>[r("div",{class:"account-growth",ref_key:"accountGrowthChartRef",ref:f},null,512)]),_:1},8,["header"])])}}});const ne=V(ee,[["__scopeId","data-v-27ab6b99"]]);export{ne as default};