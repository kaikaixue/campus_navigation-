// pages/search/search.js
const apiUtil = require('../../utils/ApiUtil.js')
const api = require('../../constants/HttpConstants')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    pathList: [
      {
        time: 37,
        distance: 1,
        placeList: ['雪松苑3栋','第一餐厅','大创楼','敬业楼']
      },
      {
        time: 55,
        distance: 3.6,
        placeList: ['雪松苑3栋','第一餐厅','大创楼','行政楼','乐群楼','敬业楼']
      },
    ],
    placeList: [],  // 地址列表
    primaryPlace: {id: 1, name: '雪松苑3栋'},
    targetPlace: {id: 2, name: '敬业楼'},
    flag: 0,
    isShow: false,  // 是否显示遮罩层
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.requestPlaceList()
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
  },

  /**
   * 关闭选择框
   */
  hiddenSelect() {
    var that = this
    that.setData({
      isShow: false
    })
  },

  /**
   * 选择地点,0是原地点，1是目标地点
   */
  selectPlace(e) {
    let flag = this.flag
    let item = e.currentTarget.dataset
    if (flag == 0) {
      this.setData({
        primaryPlace: {id: item.pk_id, name: item.name}
      })
    } else {
      this.setData({
        targetPlace: {id: item.pk_id, name: item.name}
      })
    }
  },
})