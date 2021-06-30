var data = {
    data(){
        return {
            form:{
                addRoleData: {
                    name:"",
                    code:"",
                    maxCount:"",
                },
                value: "",
            },
            activeNames:['1'],
            //角色权限数据
            rolePermissionData:"",
            //添加表单dialog显示控制
            dialogFormVisible:false,

            // 添加角色有关数据
            tableData:"",
            treeData:"",
            treeShow:false,
            //数据权限选择框
            options: [{
                value: 'all',
                label: '全部'
            }, {
                value: 'treeCustomize',
                label: '自定义'
            },],

            treeProps:{
                children: 'children',
                label: 'name'
            },
            //添加角色信息不能为空提示
            rules:{
                name:[{
                    required:true,message:"请输入角色名",trigger:"blur"
                }],
                code:[{
                    required:true,message:"请输入角色码",trigger:"blur"
                }],
                maxCount:[{
                    required:true,message:"请输入最大使用人数",trigger:"blur"
                },
                    {
                        type:'number',message: "必须为数字值",
                    }],
                value:[{
                    required:true,message:"请选择数据权限",trigger:"change"
                }],
            },
            //互斥角色信息
            table_Exclusion_Data:"",
            exclusion_tree_data:"",
            // exclusion_show:false,
            exclusion_Props:{
                label:"name",
            }

            // totalitems:0,
            // pagesize: 3,
            // // totalpages:0,
            // currentPage:1
        }
    },
    created(){
        this.loadData();
        this.loadExclusionData();
    },
    methods:{
        //载入角色数据
        loadData(){
            axios.get("/selectRole").then(res=>{
                this.tableData = res.data.data;
                console.log(res.data);
                // this.totalitems = res.data.length;
            })
            //this.getPageData(this.currentPage,this.pagesize);
        },
        // getPageData(v1,v2){
        //     axios.get("/userforpage?current="+v1+"&size="+v2).then(res=>{
        //         this.tableData = res.data;
        //     })
        // },
        // currentChange(val){
        //     this.currentPage = val;
        //     this.getPageData(val,this.pagesize)
        // },
        //打开添加对话框
        add(){
            this.getTreeGroup()
            this.dialogFormVisible=true;
        },
        //获取用户组tree数据
        getTreeGroup(){
            axios.get("/api/group/user/tree").then(res=>{
                this.treeData = res.data.data;
            })
        },
        //自定义显示用户组tree
        treeCustomize(value){
            this.form.value = value;
            console.log(this.form.value)
            if(value === "treeCustomize"){
                this.treeShow = true;
            }
            else
                this.treeShow = false;
        },
        //添加表单提交验证
        roleConfirmClick(formName){
            // this.rolePermissionData = this.$refs.userTree.getCheckedNodes()
            // console.log(this.rolePermissionData)
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    console.log('添加成功');
                    this.FormCommit();
                }
            });
        },
        //提交角色数据
        FormCommit(){
            axios.post("/insertRole",this.form.addRoleData).then(res=>{
                alert(res.data.msg);
            })
        },
        //重置添加表单
        resetForm(formName) {
            this.treeShow = false;
            this.$refs[formName].resetFields();
        },
        //删除角色
        deleteRole(id){
            if(confirm("确定删除此角色？")){
                axios.get("/deleteRole/"+id).then(res=>{
                    alert(res.data.msg);
                })
            }
        },
        //载入互斥角色组信息数据
        loadExclusionData(){
            axios.get("/getExclusionGroup").then(res=>{
                this.exclusion_tree_data = res.data.data;
                console.log(this.exclusion_tree_data);
            })
        },
        handleNodeClickExclusion(data){
            axios.get("/getExclusionRole/"+data.id).then(res=>{
                this.table_Exclusion_Data = res.data.data;
            })
        }
    }
};
// const app = Vue.createApp(data);
// app.use(ElementPlus)
// app.mount("#app");