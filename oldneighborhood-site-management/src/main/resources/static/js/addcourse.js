/**
  *this collect the information of a new-added course
  *验证不能用不知为什么/////
  *
  */

$().ready(function() {
	$("#course_info").validate({
        rules: {
            coursename:"required",
            courseteacher: "required",
            coursegrade: "required"
        },
        
        messages: {
        	coursename: "请输入课程名",
        	courseteacher: "请输入课程老师",
        	coursegrade: "请输入年级"
        }
    });
	
	$("#addcourse").click(function(){
		
		var coursename=$('#coursename').val();
		var brief=$('#courseintro').val();
		
		console.log(coursename+brief);
		
		
		var page = ("<div class='card-body'><h6 class='card-title mb-1' style='color:black'>" + coursename 
				+"</p><hr/><p class='card-text small' id='#'>" + brief
				+"</p><hr/></div>");
		
		$.ajax({
			type:"POST",
			url:"/addCourse",
			contentType:'application/json',
			data:JSON.stringify({
				'courseName':coursename,
				'brief':brief
			}),
			dataType:"json",
//			timeout:15000,
			success: function(data){
				console.log(data);
				if (data.result=="success") {
					toastr.success("新增成功！");
					$("#course_info").html(page);
				}
			},
			error: function(e){    //失败后回调
				toastr.error("添加失败！");
			}		
		})
		
	})


})
