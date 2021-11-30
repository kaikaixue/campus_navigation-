<!--
 * @Author: your name
 * @Date: 2021-05-09 11:39:58
 * @LastEditTime: 2021-11-30 09:57:37
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
      <div class="img">
        <div class="time">
          {{nowDateTime}}
        </div>
         <div class="crest">
          <img src="../../assets/image/crest.jpg" alt="" style="width: 100%; height: 100%">
        </div>
      </div>
      <div class="card">
        <div class="top">
          <p style="margin-top: 16px;color:black ">校园导航后台</p>
        </div>
        <div class="import" style="">
          <v-form>
            <v-text-field
              label="账号"
              hint="请输入账号或手机号"
              v-model="account"
            ></v-text-field>
          </v-form>
          <v-form style="margin-top:20px">
            <v-text-field
              label="密码"
              type="password"
              v-model="password"
            ></v-text-field>
          </v-form>
        </div>
        <div class="button">
         <v-btn class="ma-2" outlined color="indigo">
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
      nowDateTime:"",
    };
  },
  methods: {
    login() {},currentTime(){
    
    setInterval(this.getTime,500)
  },
  getTime(){
    
    var _this=this;
    let year=new Date().getFullYear();
    let month=new Date().getMonth();
    let date=new Date().getDate();
    let hour=new Date().getHours();
    let minute=new Date().getMinutes()<10 ? '0'+ new Date().getMinutes():new Date().getMinutes();
    let second=new Date().getSeconds()<10 ? '0'+ new Date().getSeconds():new Date().getSeconds();
    this.nowDateTime=year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
    
  }
  }, 
  created() {
   
    this.currentTime();
  }
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
  margin-top: 10%;
  width: 100%;
  height: 20%;
}

.import {
  width: 70%;
  height: 40%;
  display: flex;
  justify-content: center;
  align-items: center;
  display: inherit;
  margin: auto;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
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
  height: 25%;
}
.v-btn {
  width: 57%;
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
  background-color:#fff;
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
  width: 65%;
  height: 70%;

}
.img {
  float: left;
  position: absolute;
  width: 50%;
  height: 100%;
  background-color:#409eff;
}
.time{
  width: 100%;
  height: 15%;
  color:#fff;
  font-size: 20px;
  margin-left:15px ;
  margin-top: 10px;
}
.crest{
  width: 50%;
  height: 55%;
  background: #049ec4;
  margin: auto;
  top: 20;
  bottom: 0;
  left: 0;
  right: 0;
 
}
</style>
