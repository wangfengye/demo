<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8"/>
    <title>apk manage</title>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="./assets/css/element.css"/>
</head>
<body style="height: 100%">
<div id="content">
    <el-col :span="4" class="el-col">
        <el-menu default-active="1" v-on:select="select" style="min-height: 100%;" theme="light">
            <el-menu-item index="1">首页</el-menu-item>
            <el-menu-item index="2">添加应用</el-menu-item>
        </el-menu>
    </el-col>
    <el-col :span="20" style="height: 100%;">
        <h4>{{data.name}}</h4>
        <iframe scrolling="no" allowfullscreen="true" class="content" :src="data.url"></iframe>
    </el-col>

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
            data: {name: "首页", url: "./index"}
        },
        mounted: function () {

            this.initData();
        },
        methods: {
            initData: function () {

            },
            select: function (key, keyPath) {
                console.log(key)
                switch (key) {
                    case "1":
                            console.log(1)
                        this.data = {name: "首页", url: "./index"}
                        break;
                    case "2":
                        console.log(2)
                        this.data = {name: "添加应用", url: "./addApk"}
                        break;
                }

            },
            download: function (url) {
                window.location.href = url;
            },
            linkToHistory: function (name) {
                window.location.href = "history?name=" + name;
            },
        }
    })
</script>
<style>
    html {
        height: 100%;
    }

    body {
        margin: 0;
        height: 100%;
    }

    h4 {
        margin: 0;
        padding: 1.33rem;
        background: #50bfff;
        color: white;
    }

    #content {
        height: 100%;
    }

    .el-col {
        height: 100%;
    }

    .content {
        border: 0;
        overflow-y: hidden;
        overflow-x: hidden;
        width: 100%;
        height: 100%;

    }

    .header_container {
        background-color: #EFF2F7;
        height: 60px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding-left: 20px;
    }

    .avator {
    . wh(36 px, 36 px);
        border-radius: 50%;
        margin-right: 37px;
    }

    .el-dropdown-menu__item {
        text-align: center;
    }
</style>
</html>