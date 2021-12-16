// pages/search/search.js
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
    polyline: [],
    pathList: [
      // {
      //   time: 37,
      //   distance: 1,
      //   path: ['雪松苑','第一餐厅','大创楼','敬业楼']
      // },
      // {
      //   time: 55,
      //   distance: 3.6,
      //   path: ['雪松苑','第一餐厅','大创楼','行政楼','乐群楼','敬业楼']
      // },
    ],
    placeList: [],  // 地址列表
    primaryPlace: {id: 1, name: '雪松苑', latitude: "", longitude: ""},
    targetPlace: {id: 2, name: '敬业楼', latitude: "", longitude: ""},
    flag: 0,
    isShow: false,  // 是否显示遮罩层
    distanceList: [], // 路径列表
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.requestPlaceList()
    let that = this;
    that.requestLocation();
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

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
   * 请求所有地址
   */
  requestPlaceList() {
    var that = this
    apiUtil.request(api.placeList).then(res => {
      that.setData({
        placeList: res.data.list
      })
    })
  },
  
  /**
   * 打开选择框
   */
  showSelect(e) {
    var that = this
    that.setData({
      flag: e.currentTarget.dataset.flag,
      isShow: true
    })
    var animation = wx.createAnimation({
      delay: 0,
      duration: 200,
      timingFunction: 'ease'
    })
    animation.opacity(1).step()
    that.setData({
      selectAnimation: animation.export()
    })
  },

  /**
   * 关闭选择框
   */
  hiddenSelect() {
    var that = this
    that.setData({
      isShow: false,
      selectAnimation: null
    })
  },

  /**
   * 选择地点,0是原地点，1是目标地点
   */
  selectPlace(e) {
    var that = this
    let flag = that.data.flag
    let item = e.currentTarget.dataset.item
    console.log(e.currentTarget.dataset)
    if (flag == 0) {
      that.setData({
        primaryPlace: {id: item.pkId, name: item.name, latitude: item.latitude, longitude: item.longitude}
      })
    } else {
      that.setData({
        targetPlace: {id: item.pkId, name: item.name, latitude: item.latitude, longitude: item.longitude}
      })
    }
    that.hiddenSelect()
  },

  /**
   * 搜索最短路径
   */
  search: function() {
    var that = this
    let data = {
      primaryAddress: this.data.primaryPlace.id,
      targetAddress: this.data.targetPlace.id
    }
    apiUtil.request(api.searchPath, data).then((res) => {
      console.log(res.data)
      res.data.path = res.data.path.reverse()
      let list = [];
      list[0] = res.data
      let points = []
      for (let i in res.data.path) {
        let params = {
          latitude: res.data.path[i].latitude,
          longitude: res.data.path[i].longitude
        }
        points.push(params)
      }
      var polyline = [{
        points: points,
        color: '#ff0000',
        width: 5,
      }]
      that.setData({
        pathList: list,
        polyline: polyline
      })
      console.log(that.data.polyline)
    })
  },

  /**
   * 导航
   * @param {}} e 
   */
  getLocation: function() {
    var that = this
    console.log(this.data.primaryPlace)
    wx.chooseLocation({
      latitude: (Number)(that.data.primaryPlace.latitude),
      longitude: (Number)(that.data.primaryPlace.longitude),
      success () {
        wx.openLocation({
          latitude: (Number)(that.data.targetPlace.latitude),//目的地的纬度
          longitude: (Number)(that.data.targetPlace.longitude),//目的地的经度
          name: that.data.targetPlace.name, //打开后显示的地址名称
        })
      }
    })  
  },
})