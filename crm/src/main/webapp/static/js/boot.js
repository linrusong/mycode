/**
 * Created with IntelliJ IDEA.
 * User: Jay
 * Date: 13-12-31
 * Time: 上午9:51
 * To change this template use File | Settings | File Templates.
 */




__CreateContextPath = function () {
    var href = location.href;
    href = href.split("#")[0];
    href = href.split("?")[0];
    var ss = href.split("/");
    ss = ss.slice(0, 4);
//    ss.length = ss.length - 1;
    return ss.join("/");
};

var bootPATH = __CreateContextPath();


/*document.write('<script src="' + bootPATH + '/static/easyui/jquery.easyui.min.js" type="text/javascript" charset="UTF-8"></sc' + 'ript>');
document.write('<script src="' + bootPATH + '/static/easyui/jquery.min.js" type="text/javascript" charset="UTF-8" ></sc' + 'ript>');
document.write('<script src="' + bootPATH + '/static/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="UTF-8" ></sc' + 'ript>');
document.write('<link href="' + bootPATH + '/static/easyui/themes/icon.css" rel="stylesheet" type="text/css" />');
document.write('<link href="' + bootPATH + '/static/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />');*/

