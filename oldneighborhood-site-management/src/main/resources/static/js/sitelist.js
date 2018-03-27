/**
 * Created by st0001 on 2017/12/15.
 */
$().ready(function() {
	$.ajax({
		url: "/oldneighborhood/site/list",
		type: 'post',
		success: function (data) {
			console.log(data);
			var courseList = $("#courselist");
			var courseHTML = '';
			//json数据解析
			var obj = eval ("(" + data + ")");
			for (i in obj){
				var id = obj[i].id;
				var tid = obj[i].tid;
				var course = obj[i].name;
				var brief = obj[i].brief;
				courseHTML += ' <div class="col-xl-3 col-sm-6 mb-3"><div class="card text-white bg-primary o-hidden h-100">'
					+ '<div class="card-body" id= '
					+ id + '><div class="card-body-icon"><i class="fa fa-fw fa-book"></i></div>'
					+ '<div class="mr-5"> '
					+ course + '</div> </div> <a class="card-footer text-white clearfix small z-1" href="/courseDetail?courseId='
					+ id + '">'
					+ '<span class="float-left">详细信息</span><span class="float-right"><i class="fa fa-angle-right"></i></span></a></div></div>';
			}
			courseList.html(courseHTML);
		},
		error: function(e){    //失败后回调
			toastr.error("出错了");
		},
		datatype: "json"
	})
	
	
});

