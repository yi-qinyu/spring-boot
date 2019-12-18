$(function (){
    initSfsm();
    initLabelBind();
    initEditorCss();

    //文章分类下拉框数据初始化
    $("#wzfl").append("<option value='yc'>原创</option>")
        .append("<option value='zz'>转载</option>")
        .append("<option value='fy'>翻译</option>");
    $("#wzfl").selectpicker('refresh');

    //博文分类下拉框数据初始化
    initBwfl();

});

//缓存添加的标签内容
var labelCache= new Map();

function addBq() {
    $("#labelin").show();
    $("#labeltext").focus();
};

function addAction(){
    var label = $("#labeltext").val();
    if(label==null || label==""){
        //输入为空不处理
        $("#labeltext").val("");
        $("#labelin").hide();
    }else{
        var id ="lable_"+ (new Date()).getTime();
        labelCache.put(id,label);
        $("#blogLabel").append("<div id='"+id+"' style='display: inline;'></div>");
        $("#"+id).append("&nbsp;&nbsp;&nbsp;<span style='height: 20px;font-size: 15px;' class='label label-info'>"+label+"</span>");
        $("#"+id).append("<span aria-hidden='true' onclick=\"deleteLabel('"+id+"')\" class='add-close'>×</span>");
        $("#labeltext").val("");
        $("#labelin").hide();
    }
}

function deleteLabel(id) {
    $("#"+id).remove();
    labelCache.remove(id);
}

function initLabelBind(){
    $("#labeltext").bind("keydown",function (event) {
        if(event.keyCode=="13"){
            addAction();
        }
    });
}


function initSfsm() {
    $("#sfsm").bootstrapSwitch({
        onText:"私密",
        offText:"公开",
        onColor:"success",
        offColor:"info",
        size:"small",
        onSwitchChange:function(event,state){
            // if(state==true){
            //     alert('已打开');
            // }else{
            //     alert('已关闭');
            // }
        }
    });
}

function saveBlog() {
    var bwbt = $("#bwbt").val();
    var content = $("#editor").html();
    var wzbq = function () {
        var wzbqs = labelCache.values();
        for(var i=0;i<wzbqs.length;i++){
            
        }
        return "dsfsfsdfs";
    }
    var sfsm = $("#sfsm").val();
    var wzfl = $("#wzfl").val();
    var bwfl = $("#bwfl").val();
    console.log(wzbq());
}

function getWzbq() {
    var wzbqs = labelCache.values();
    var bq="";
    for(var i=0;i<wzbqs.length;i++){

    }
    return "dsfsfsdfs";
}

function cacheBlog() {
    // var url="http://localhost:8080/initBwfl";
    // var data={'id':'20125002'};
    // $.ajax({
    //     type: 'POST',
    //     url: url,
    //     data: data,
    //     success: function (data) {
    //         console.log(data);
    //
    //     }
    // });
}

function initBwfl(){
    var url="http://localhost:8080/initBwfl";
    $.ajax({
        type: 'POST',
        url: url,
        data: {},
        success: function (data) {
            for(var i=0; i<data.length;i++){
                $("#bwfl").append("<option value='"+data[i].bwfldm+"'>"+data[i].bwflmc+"</option>");
            }
            $("#bwfl").selectpicker('refresh');

        }
    });
}

/**
 * 自定义下拉框样式，下拉过长
 * 富文本编辑器显示层级过高
 */
function initEditorCss() {
    $(".w-e-text-container").css("z-index","100");
    $(".w-e-menu").css("z-index","101");
    $(".dropdown-menu ").css("max-height","200px");
    $(".dropdown-menu ").css("min-height","20px");
}

