<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8"/>
    <title>apk manage</title>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="./assets/css/element.css"/>
</head>
<body>
<div id="content">
    <el-form style="width:50%" ref="form" :model="form" label-width="80px">
        <el-form-item label="Apk 名称">
            <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="版本号">
            <el-input v-model="form.version"></el-input>
        </el-form-item>
        <el-form-item label="内部编号">
            <el-input type="number" v-model="form.code"></el-input>
        </el-form-item>
        <el-form-item label="apk">
            <el-upload class="upload-demo" :action="uploadUrl" :on-preview="handlePreview" :on-remove="handleRemove"
                       :file-list="fileList" :on-success="uploadSuccess">
                <el-button size="small" type="primary">点击上传</el-button>
            </el-upload>
        </el-form-item>

        <el-form-item label="更新说明">
            <el-input type="textarea" v-model="form.desc"></el-input>
        </el-form-item>
        <el-form-item label="更新日期">
            <el-col :span="11">
                <el-date-picker type="date" placeholder="选择日期" v-model="form.updateDate"
                                style="width: 100%;"></el-date-picker>
            </el-col>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" v-on:click="onSubmit">立即提交</el-button>
        </el-form-item>
    </el-form>
</div>
</body>
<!-- 引入组件库 -->
<script src="./assets/js/jquery.min.js"></script>
<script src="./assets/js/vue.js"></script>
<script src="./assets/js/element.js"></script>
<script>
    var content = new Vue({
        el: '#content',
        data: {
            fileList: [],
            uploadUrl: "./file/upload",
            mainThis: '',
            form: {
                name: '',
                version: '',
                code: '',
                apkUrl: '',
                desc: '',
                updateDate: ''
            }
        },
        mounted: function () {
            this.mainThis = this;
            this.initData();
        },
        methods: {

            initData: function () {

                let date = new Date();
                this.form.updateDate = date.getFullYear() + "-"
                        + (date.getMonth() + 1) + "-"
                        + date.getDate();
            },
            onSubmit: function () {

                let _this = this;
                console.log("form" + _this.version);
                $.ajax({
                    "type": "POST",
                    "url": "app",
                    data: {
                        name: _this.form.name,
                        version: _this.form.version,
                        code: _this.form.code,
                        apkUrl: _this.form.apkUrl,
                        desc: _this.form.desc,
                        updateDate: _this.form.updateDate,
                    },
                    "dataType": "json",
                    "success": function (e) {
                        _this.show("success");
                    },
                    "error": function (e) {
                       _this.show("error");
                    }
                });
            },
            handlePreview: function (file) {//可选参数, 点击已上传的文件链接时的钩子, 可以通过 file.response 拿到服务端返回数据
                console.log(file);
            },
            handleRemove: function () {//可选参数, 文件列表移除文件时的钩子

            },
            uploadSuccess: function (response) {
                console.log(response)
                this.form.apkUrl = response;

            },
            show: function (message) {
                switch (message){
                    case "success":
                        this.$message({
                            message: '提交成功',
                            type: 'success'
                        });
                        break;
                    case "error":
                        this.$message({
                            message: '提交失败',
                            type: 'error'
                        });
                        break
                }

            }

        }
    })
</script>
</html>