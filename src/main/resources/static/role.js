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
            addRolePermissionData:{
                role_id:"",
                permissionIds:[]
            },

            //数据权限选择框
            options: [{
                value: 'all',
                label: '全部'
            }, {
                value: 'treeCustomize',
                label: '自定义'
            },],
            //添加权限树
            role_permission_show:false,
            role_permission_data:"",
            role_permission_props:{
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
            //互斥
            exclusion_group_id:'',
            table_Exclusion_Data:"",
            exclusion_tree_data:"",
            // exclusion_show:false,
            exclusion_Props:{
                label:"name",
            },

            //添加互斥角色组
            exclusion_show: false,
            exclusion_form:{
                addExclusionGroupData:{
                    name:"",
                    description:"",
                    roleIds:[],
                }
            },
            exclusion_options:"",
            exclusion_rules:{
                name:[{
                    required:true,message:"请输入角色名",trigger:"blur"
                }],
            },

            //先决
            include_group_role:"",
            include_group_id:"",
            table_Include_Data:"",
            include_tree_data:"",
            include_show:false,
            include_Props:{
                label:"name",
            },

            //合并
            merge_group_role:"",
            merge_group_id:"",
            table_Merge_Data:"",
            merge_tree_data:"",
            merge_show:false,
            merge_Props:{
                label:"name",
            },

        }
    },
    created(){
        this.loadData();
        this.loadPermissionTreeData();
        this.loadExclusionData();
        this.loadIncludeData();
        this.loadMergeData();
    },
    methods:{
        //载入角色数据
        loadData(){
            axios.get("/selectRole").then(res=>{
                this.tableData = res.data.data;
                // this.totalitems = res.data.length;
            })
            //this.getPageData(this.currentPage,this.pagesize);
        },
        loadPermissionTreeData(){
            axios.get("/api/getAllPermissions").then(res=>{
                this.role_permission_data = res.data.data
            })
        },
        //打开添加对话框
        add(){
            this.dialogFormVisible=true;
        },
        //打开添加权限对话框
        addRolePermission(id){
            this.role_permission_show = true
            this.addRolePermissionData.role_id = id
        },
        addPermissionConfirmClick(){
            this.addRolePermissionData.permissionIds = this.$refs.permission_tree.getCheckedKeys()
            axios.post("/role/"+this.addRolePermissionData.role_id+"/insertPermission",this.addRolePermissionData.permissionIds).then(res=>{
                alert(res.data.msg)
                this.role_permission_show = false
            })
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
                this.dialogFormVisible = false;
                this.loadData();
            })
        },
        //重置添加表单
        resetForm(formName) {
            this.$refs[formName].resetFields();
        },
        //删除角色
        deleteRole(id){
            if(confirm("确定删除此角色？")){
                axios.get("/deleteRole/"+id).then(res=>{
                    alert(res.data.msg);
                    this.loadData();
                })
            }
        },

        //载入互斥角色组信息数据
        loadExclusionData(){
            axios.get("/exclusionGroup/get").then(res=>{
                this.exclusion_tree_data = res.data.data;
            })
        },
        //点击互斥组显示其包含角色
        handleNodeClickExclusion(data){
            this.exclusion_group_id = data.id;
            axios.get("/getExclusionRole/"+this.exclusion_group_id).then(res=>{
                this.table_Exclusion_Data = res.data.data;
            })
        },
        //点击新增角色组显示dialog
        add_exclusion(){
            this.exclusion_show = true;
        },
        //重置新增角色组dialog
        exclusion_resetForm(formName){
            this.$refs[formName].resetFields();
        },
        //提交新增角色组表单进行验证
        exclusion_roleConfirmClick(formName){
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    console.log('添加成功');
                    this.exclusionFormCommit();
                }
            });
        },
        //提交新增角色组数据
        exclusionFormCommit(){
            axios.post("/exclusionGroup/add",this.exclusion_form.addExclusionGroupData).then(res=>{
                alert(res.data.msg)
                this.exclusion_show = false
                this.loadExclusionData()
            })
        },
        exclusionDeleteRole(roleid){
            if(confirm("确定删除此角色？")){
                axios.get("/exclusionGroupItem/del/"+roleid+"/"+this.exclusion_group_id).then(res=>{
                    alert(res.data.msg);
                    this.loadExclusionData()
                })
            }
        },

        //先决
        //载入先决信息
        loadIncludeData(){
            axios.get("/includeGroup/get").then(res=>{
                this.include_tree_data = res.data.data
            })
        },

        handleNodeClickInclude(data){
            this.include_group_id = data.id;
            axios.get("/getIncludeRole/"+this.include_group_id).then(res=>{
                this.table_Include_Data = res.data.data;
            })
        },
        add_include(){
            this.include_show = true;
        },

        //合并
        //载入合并信息
        loadMergeData(){
            axios.get("/mergeGroup/get").then(res=>{
                this.merge_tree_data = res.data.data
            })
        },

        handleNodeClickMerge(data){
            this.merge_group_id = data.id;
            axios.get("/getMergeRole/"+this.merge_group_id).then(res=>{
                this.table_Merge_Data = res.data.data;
            })
        },
        add_include(){
            this.merge_show = true;
        },



        roleManage(index){
            if(index==2){
                window.location.href="http://localhost:80/role.html"
                //window.location.href="role.html"
            }
            if(index==1){
                window.location.href="user1.html"
            }
            if(index==4){
                window.location.href="menu.html"
            }
        }
    }
};
// const app = Vue.createApp(data);
// app.use(ElementPlus)
// app.mount("#app");