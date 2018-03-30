/**
 * Created by st0001 on 2017/12/15.
 */
$().ready(function() {
	$.ajax({
		url: "/oldneighborhood/site/list",
		type: 'post',
		success: function (data) {
			console.log(data);
			var sitelist = $("#sitelist");
			var siteHTML = '';
			//json数据解析
			var obj = eval ("(" + data + ")");
			for (i in obj){
				var id = obj[i].id;
				var tid = obj[i].tid;
				var course = obj[i].name;
				var brief = obj[i].brief;
				siteHTML += ' <div class="col-xl-3 col-sm-6 mb-3"><div class="card text-white bg-primary o-hidden h-100">'
					+ '<div class="card-body" id= '
					+ id + '><div class="card-body-icon"><i class="fa fa-fw fa-book"></i></div>'
					+ '<div class="mr-5"> '
					+ course + '</div> </div> <a class="card-footer text-white clearfix small z-1" href="/courseDetail?courseId='
					+ id + '">'
					+ '<span class="float-left">详细信息</span><span class="float-right"><i class="fa fa-angle-right"></i></span></a></div></div>';
			}
			sitelist.html(siteHTML);
		},
		error: function(e){    //失败后回调
			toastr.error("出错了");
		},
		datatype: "json"
	})
	
	$("#newsite").click(function(){
		var sitebody = $("#sitebody");
		addsiteHTML = '<div class="card mb-3"><div class="card-header"><i class="fa fa-pencil"></i> 新增景点</div>'
			+ '<div class="card-body"><div class="table-responsive"><form role="form">'
				+ '<div class="form-group"><label for="site_name">名称：</label> <input type="text" class="form-control w-50" id="site_name" placeholder="北大楼" /></div>'
				+ '<div class="form-group"><label for="site_address">地址：</label> <input type="text" class="form-control w-50" id="site_address" placeholder="汉口路22号" /></div>'
				+ '<div class="form-group"><label for="site_type">类型（景区/停车场/卫生间）：</label> <input type="text" class="form-control w-50" id="site_type" /></div>'
				+ '<div class="form-group"><label for="site_ticket">门票费用(元)：</label> <input type="text" class="form-control w-50" id="site_ticket" placeholder="20.00" /></div>'
				+ '<div class="form-group"><label for="site_time">开放时间：</label> <input type="text" class="form-control w-50" id="site_time" placeholder="周一~周五：10:00-17:00\n周末：10:00-18:00" /></div>'
				+ '<button type="button" class="btn btn-primary id="release" onclick="release()">发布</button></form></div></div></div>';
		sitebody.html(addsiteHTML);
		console.log('line46');
		$().ready(function() {
			console.log('line48');
			
			
			
			$("#release").on('click',function(){
				console.log('line50');
				var site_name = $("#site_name");
				var site_address = $("#site_address");
				var site_type = $("#site_type");
				var site_ticket = $("#site_ticket");
				var site_time = $("#site_time");
				$.ajax({
		            url: '/oldneighborhood/site/add',
		            type: 'post',
		            contentType:'application/json',
		            data: JSON.stringify({
		            	"site_name":site_name,
		            	"site_address":site_name,
		            	"site_type":site_name,
		            	"site_ticket":site_name,
		            	"site_time":site_name
		            	}),
		            success: function (data) {   //成功后回调
		            	toastr.success("新增成功！");
		                console.log(data);
		            },
		            error: function(e){    //失败后回调
		                toastr.error("出错了");
		            },
		            datatype: "json"
		    	})
			})//release click
		})//ready
		
	})
	
	
	function release(){
		console.log('line50');
		var site_name = $("#site_name");
		var site_address = $("#site_address");
		var site_type = $("#site_type");
		var site_ticket = $("#site_ticket");
		var site_time = $("#site_time");
		$.ajax({
            url: '/oldneighborhood/site/add',
            type: 'post',
            contentType:'application/json',
            data: JSON.stringify({
            	"site_name":site_name,
            	"site_address":site_name,
            	"site_type":site_name,
            	"site_ticket":site_name,
            	"site_time":site_name
            	}),
            success: function (data) {   //成功后回调
            	toastr.success("新增成功！");
                console.log(data);
            },
            error: function(e){    //失败后回调
                toastr.error("出错了");
            },
            datatype: "json"
    	})
	}
	
});

