// pages/index/index.js
// 引入SDK核心类
import QQMapWX from '../../utils/qqmap-wx-jssdk.min.js'
// var QQMapWX = require('../../utils/qqmap-wx-jssdk.min')
var qqmapsdk;
const apiUtil = require('../../utils/ApiUtil.js')
const api = require('../../constants/HttpConstants')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    longitude: 118.93476, // 经度
    latitude: 32.12169, // 纬度
    scale: 18, // 缩放级别
    total: 10, // 总共地点数
    placeList: [],  // 地点列表
    placeDetail: {},  // 地点信息 
    isShowDetail: false,  // 是否显示详情
    isShowMark: false,  // 是否显示遮罩层
    animationData: {},  // 弹出动画
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let that = this;
    that.requestLocation();
    that.requestPlaceList();
  },

  /**
   * 请求地点列表
   */
  requestPlaceList() {
    var that = this
    apiUtil.request(api.placeList).then((res) => {
      console.log(res.data)
      that.setData({
        total: res.data.total,
        placeList: res.data.list
      })
    })
  },

  /**
   * 请求地址
   */
  requestLocation() {
    var that = this
    wx.getLocation({
      type: 'gcj02',
      isHighAccuracy: true,
      altitude: true,
      success: function (res) {
        that.setData({
          longitude: res.longitude,
          latitude: res.latitude
        })
        // that.moveTolocation()
      }
    })
  },

  /**
   * 移动到中心点
   */
  moveTolocation: function () {
    var that = this
    var mapCtx = wx.createMapContext("map");
    mapCtx.moveToLocation();
    that.setData({
      scale: 18
    })
  },

  /**
   * 跳转搜索页面
   */
  goToSearch() {
    wx.navigateTo({
      url: '../search/search',
    })
  },

  /**
   * 导航
   */
  getLocation: function(e) {
    console.log(e.target.dataset)
    wx.openLocation({
      latitude: (Number)(e.target.dataset.item.latitude),//目的地的纬度
      longitude: (Number)(e.target.dataset.item.longitude),//目的地的经度
      name: e.target.dataset.item.name, //打开后显示的地址名称
    })
     // 使用微信内置地图查看位置
    //  wx.getLocation({
    //   type: 'gcj02', //返回可以用于wx.openLocation的经纬度
    //   success: (res) => {
    //     wx.openLocation({
    //       latitude: (Number)(e.target.dataset.item.latitude),//目的地的纬度
    //       longitude: (Number)(e.target.dataset.item.longitude),//目的地的经度
    //       name: e.target.dataset.item.name, //打开后显示的地址名称
    //     })
    //   }
    // })
  },

  /**
   * 显示详情
   */
  showDetail: function(e) {
    let id = e.target.dataset.id
    var that = this
    let data = {
      id: id
    }
    apiUtil.request(api.placeDetail,data).then((res) => {
      that.setData({
        placeDetail: res.data,
      })
      var animation = wx.createAnimation({
        delay: 0,
        duration: 70,
        timingFunction: 'linear'
      })
      this.animation = animation
      animation.translateY(1000).step()
      that.setData({
        animationData: animation.export(),
        isShowDetail: true,
        isShowMark: true
      })
      setTimeout(function () {
        animation.translateY(0).step()
        that.setData({
          animationData: animation.export()
        })
      }.bind(this), 70)
    })
  },

  /**
   * 隐藏详情
   */
  hiddenDetail: function () {
    var that = this
    var animation = wx.createAnimation({
      delay: 0,
      duration: 200,
      timingFunction: 'linear'
    })
    this.animation = animation
    animation.translateY(1000).step()
    that.setData({
      animationData: animation.export()
    })
    setTimeout(function () {
      animation.translateY(0).step()
      that.setData({
        animationData: animation.export(),
        isShowMark: false,
        isShowDetail: false
      })
    }.bind(this), 200)
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {},

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})