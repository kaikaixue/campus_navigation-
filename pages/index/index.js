// pages/index/index.js
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
    placeList: []
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
    console.log(apiUtil)
    apiUtil.request(api.placeList).then((res) => {
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
    var mapCtx = wx.createMapContext("map");
    mapCtx.moveToLocation();
    this.setData({
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