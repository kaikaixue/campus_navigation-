// pages/index/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    longitude: 118.93476, // 经度
    latitude: 32.12169, // 纬度
    scale: 18, // 缩放级别
    total: 10,  // 总共地点数
    placeList: [{
        imgUrl: "https://xuekaikai.oss-cn-shanghai.aliyuncs.com/campus_navigatic/firstRestaurant.jpg",
        name: "第一餐厅"
      },
      {
        imgUrl: "https://xuekaikai.oss-cn-shanghai.aliyuncs.com/campus_navigatic/library.jpg",
        name: "图书馆"
      },
      {
        imgUrl: "https://xuekaikai.oss-cn-shanghai.aliyuncs.com/campus_navigatic/firstRestaurant.jpg",
        name: "第一餐厅"
      },
      {
        imgUrl: "https://xuekaikai.oss-cn-shanghai.aliyuncs.com/campus_navigatic/library.jpg",
        name: "图书馆"
      },
      {
        imgUrl: "https://xuekaikai.oss-cn-shanghai.aliyuncs.com/campus_navigatic/firstRestaurant.jpg",
        name: "第一餐厅"
      },
      {
        imgUrl: "https://xuekaikai.oss-cn-shanghai.aliyuncs.com/campus_navigatic/library.jpg",
        name: "图书馆"
      }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let that = this;
    that.requestLocation();
  },

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

  moveTolocation: function () {
    var mapCtx = wx.createMapContext("map");
    mapCtx.moveToLocation();
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