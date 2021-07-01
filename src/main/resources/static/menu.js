const data = {
    data(){
        return {
            //菜单信息
            menu_Data: [],
        }
    },

    created(){
        this.loadMenuData();
    },

    methods:{
        loadMenuData(){
            console.log(1)
            axios.get("/api/menu/tree").then(res=>{
                this.menu_Data = res.data.data;
                console.log(this.menu_Data)
            })
        },

        roleManage(index){
            if(index==2){
                // window.location.href="http://localhost:80/role.html"
                window.location.href="role.html"
            }
            if(index==1){
                window.location.href="user1.html"
            }
            if(index==4){
                window.location.href="menu.html"
            }
        },
    }
}