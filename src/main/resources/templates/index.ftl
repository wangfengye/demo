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
    <el-row>
        <el-col :span="9" v-for="(o, index) in apks" :key="index">
            <el-card :body-style="{ padding: '0px' }" class="card">
                <div style="padding: 14px;">
                    <span>{{o.name}}</span>
                    <span class="hint">{{o.version}}</span>
                    <el-button v-on:click="download(o.apkUrl)" type="primary" class="right">下载</el-button>
                    <div class="bottom clearfix">
                        <el-button v-on:click="linkToHistory(o.name)" type="text">历史版本</el-button>
                    </div>
                </div>
            </el-card>
        </el-col>
    </el-row>
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
            apks: []
        },
        mounted: function () {

            this.initData();
        },
        methods: {
            initData: function () {
               let  _this =this;
                $.ajax({
                    "type": "GET",
                    "url": "app",
                    "dataType": "json",
                    "success": function (e) {
                        _this.apks = e.data;
                    },
                });
            },
            download: function (url) {
                window.location.href=url;
            },
            linkToHistory: function (name) {
                window.location.href ="history?name="+name;
            }
        }
    })
</script>
<style>
    .right {
        margin-left: 60%;
    }

    .card {
        margin: 1%;
    }

    .hint {
        color: gray;
        font-size: 12px;
    }
</style>
</html>