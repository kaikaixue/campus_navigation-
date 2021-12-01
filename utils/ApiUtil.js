/**
 * 封装请求request
 */

 function request(url, data = {}, method = "POST") {
   return new Promise(function (resolve, reject) {
     console.log(url)
     console.log(data)
     wx.request({
       url: url,
       data: data,
       method: method,
       success: function(res) {
         if (res.data.code == 0) {
           resolve(res.data)
         } else {
           wx.hideLoading();
           reject({
             data: {
               msg: '网络异常'
             }
           })
         }
       },
       fail: function (err) {
         wx.hideLoading();
         wx.showModal({
           title: '提示',
           content: '网络请求超时',
           showCancel: false,
           success: function (res) {}
         })
         console.log('err', err)
         reject({
           data: {
             msg: '网络异常'
           }
         })
       }
     })
   })
 }

 module.exports = {
  request
}