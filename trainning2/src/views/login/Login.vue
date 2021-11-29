<!--
 * @Author: your name
 * @Date: 2021-05-09 11:39:58
 * @LastEditTime: 2021-11-29 21:44:48
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \demo\src\views\My.vue
-->
<template>
  <div class="total">
    <v-dialog v-model="dialogDelete" max-width="250px">
      <v-card>
        <v-card-title class="text-h5">账号或密码错误</v-card-title>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text @click="closeDelete">取消</v-btn>

          <v-spacer></v-spacer>
        </v-card-actions>
      </v-card>
    </v-dialog>

    <div class="framework">
      <div class="img"></div>
      <div class="card">
        <div class="top">
          <p style="margin-top: 16px;color:white ">校园导航后台登录</p>
        </div>
        <div class="import" style="">
          <v-form>
            <v-text-field
              label="账号"
              hint="请输入账号或手机号"
              v-model="account"
            ></v-text-field>
          </v-form>
          <v-form>
            <v-text-field
              label="密码"
              type="password"
              v-model="password"
            ></v-text-field>
          </v-form>
        </div>
        <div class="button">
          <v-btn rounded color="primary" dark @click="login()">
            登陆
          </v-btn>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "My",
  data() {
    return {
      flag: "",
      account: "",
      password: "",
      status: "",
      dialogDelete: false,
    };
  },
  methods: {
    login() {},
  },

  created() {},
};
</script>

<style scoped>
.total {
  height: 100%;
  width: 100%;
  position: absolute;
  background: #049ec4;
  /* background-image:url("../../assets/image/login2.jpg"); */
  background-size: 100% 100%;
  background-repeat: no-repeat;
}

.top {
  width: 100%;
  height: 20%;
}

.import {
  width: 100%;
  height: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  display: inherit;
}

.password {
  width: 100%;
  height: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.button {
  display: flex;
  justify-content: center;
  width: 100%;
  height: 15%;
}
.v-btn {
  width: 50%;
  height: 15%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.v-form {
  width: 80%;
  height: 30%;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-left: 10%;
}

.card {
  background-color: rgba(255, 200, 200, 0.1);
  width: 50%;
  height: 100%;
  position: absolute;
  right: 0%;
  
  /* opacity: 0.5; */
  /* 透明度 */
  font-size: 35px;
  text-align: center;
}
.framework {
	box-shadow: 2px 5px 2px #666666;
  position: absolute;
  margin: auto;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  font-size: 35px;
  display: inline-block;
  width: 70%;
  height: 50%;

}
.img {
  float: left;
  position: absolute;
  width: 50%;
  height: 100%;
  
}
</style>
