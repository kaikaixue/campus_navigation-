<!--
 * @Author: your name
 * @Date: 2021-11-29 21:04:16
 * @LastEditTime: 2021-11-30 11:57:29
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \trainning2\src\views\page\index.vue
-->
<template>
  <div class="total">
    <div class="navigation">
          <v-card style="height:103%">
            <v-toolbar color="teal" dark>
              <v-app-bar-nav-icon></v-app-bar-nav-icon>
              <v-toolbar-title>校园导航后台</v-toolbar-title>
              <v-spacer></v-spacer>
            </v-toolbar>
            <v-list>
              <template v-for="(item, index) in items">
                <v-list-item v-if="item.action" :key="item.title">
                  <v-list-item-action>
                    <v-icon>{{ item.action }}</v-icon>
                  </v-list-item-action>

                  <v-list-item-content>
                    <v-list-item-title>{{ item.title }}</v-list-item-title>
                  </v-list-item-content>
                  
                </v-list-item>

                <v-divider v-else-if="item.divider" :key="index"></v-divider>

                <v-subheader v-else-if="item.header" :key="item.header">
                  {{ item.header }}
                </v-subheader>
              </template>
            </v-list>
          </v-card>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      items: [
        {
          action: "mdi-inbox-arrow-down",
          title: "用户信息",
        },
        {
          action: "mdi-send",
          title: "地点信息",
        }
      ],
    };
  },
  methods: {},
  created() {},
};
</script>
<style scoped>
.total{
 height: 100%;
  width: 100%;
  position: absolute;
 
  /* background-image:url("../../assets/image/login2.jpg"); */
  background-size: 100% 100%;
  background-repeat: no-repeat;
}
.navigation{
   height: 100%;
    
    width: 20%;
  
}
</style>
