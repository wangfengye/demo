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
    <el-table :data="apkVersions" style="width:100%" v-on:expand="expand">
        <el-table-column label="详情" type="expand">
            <template scope="scope">
                <div v-html="scope.row.desc"></div>
            </template>
        </el-table-column>
        <el-table-column label="版本号" prop="version">
        </el-table-column>
        <el-table-column label="内部编号" prop="code">
        </el-table-column>
        <el-table-column label="发布时间" prop="updateDate">
            <template scope="scope">
                <el-icon name="time"></el-icon>
                <span style="margin-left: 10px">{{ scope.row.updateDate }}</span>
            </template>
        </el-table-column>
        <el-table-column class="btn_download" label="操作">
            <template class="btn_download" scope="scope">
                <el-button v-on:click="download(scope.row.apkUrl)" type="primary" size="mini">下载</el-button>
            </template>
        </el-table-column>
    </el-table>
</div>
</body>
<!-- 引入组件库 -->
<script src="./assets/js/jquery.min.js"></script>
<script src="./assets/js/vue.js"></script>
<script src="./assets/js/element.js"></script>
<script src="./assets/js/showdown.js"></script>
<script>
    var content = new Vue({
        el: '#content',
        data: {
            apkVersions: [],
        },
        mounted: function () {
            this.initData();
        },
        methods: {
            initData: function () {
                let name = this.getQueryString("name");
                let _this = this;
                $.ajax({
                    "type": "GET",
                    "url": "appVersion/all",
                    data: {name: name},
                    "dataType": "json",
                    "success": function (e) {
                        _this.apkVersions = e.data;
                    },
                });
            },
            download: function (url) {
                window.location.href = url;
                console.log(url)
            },
            expand: function (row, expanded) {
                let text = row.desc;
                if (text != null) {
                    let converter = new Showdown.converter();

                    let html = converter.makeHtml(text);
                    row.desc = html;
                }

            },
            getQueryString: function (name) {
                var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
                var r = window.location.search.substr(1).match(reg);
                if (r != null) return unescape(r[2]);
                return null;
            }
        }
    })
</script>
<style>
    .right {
        margin-right: 0%;
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