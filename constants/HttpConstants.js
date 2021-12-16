// var apiRootUrl = "http://127.0.0.1:8080";
var apiRootUrl = "http://49.234.145.215:8080";

module.exports = {
  apiRootUrl,

  /**
   * 首页
   */
  placeList: apiRootUrl + '/homepage/placeList',
  /**
   * 地点信息
   */
  placeDetail: apiRootUrl + '/homepage/detail' ,
  /**
   * 查询两点间路径
   */
  searchDistance: apiRootUrl + '/search/distance',
  searchPath: apiRootUrl + '/search/path',
}