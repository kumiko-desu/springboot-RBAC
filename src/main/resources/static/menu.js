const data = {
    data(){
        return {
            //菜单信息
            menu_Data: [],
            menu_show:false,
            form:{
                addMenuData:{
                    name:"",
                    path:"",
                    description:"",
                    parentId:"",
                }
            },
            menu_rules:{
                name:[{
                    required:true,message:"请输入菜单名",trigger:"blur"
                }],
                path:[{
                    required:true,message:"请输入菜单路径",trigger:"blur"
                }],
                parentId: [{
                    required:true,message:"请选择父菜单",trigger:"change"
                }]
            },
            menu_options:[]
        }
    },

    created(){
        this.loadMenuTreeData();
        this.loadMenuData();
    },

    methods:{
        loadMenuTreeData(){
            console.log(1)
            axios.get("/api/menu/tree").then(res=>{
                this.menu_Data = res.data.data;
                console.log(this.menu_Data)
            })
        },
        loadMenuData(){
            axios.get("/api/menu/get").then(res=>{
                this.menu_options = res.data.data;
            })
        },
        add(){
            this.menu_show = true;
        },
        resetMenuForm(formName){
            this.$refs[formName].resetFields();
        },
        MenuConfirmClick(formName){
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    console.log(this.form.addMenuData);
                    this.menuFormCommit();
                }
            });
        },
        menuFormCommit(){
            axios.post("/api/menu/add",this.form.addMenuData).then(res=>{
                alert(res.data.msg);
                this.menu_show = false
                this.loadMenuTreeData();
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