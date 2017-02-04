var User = function(){
	function handleValidation(){
		var form1 = $('#form_sample_1');
        var error1 = $('.alert-error', form1);
        var success1 = $('.alert-success', form1);
 
        $("#cancel").click(function(){
        	$("#queryForm").submit();
        });
        
        form1.validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-inline', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            ignore: "",
            rules: {
            	cityName: {
                    maxlength: 16,
                    required: true
                },
                cityLetter : {
                	maxlength:1,
                	required: true
                },
                hot: {
                    required: true
                }
            },

            invalidHandler: function (event, validator) { //display error alert on form submit              
                success1.hide();
                error1.show();
                App.scrollTo(error1, -200);
            },

            highlight: function (element) { // hightlight error inputs
                $(element)
                    .closest('.help-inline').removeClass('ok'); // display OK icon
                $(element)
                    .closest('.control-group').removeClass('success').addClass('error'); // set error class to the control group
            },

            unhighlight: function (element) { // revert the change done by hightlight
                $(element)
                    .closest('.control-group').removeClass('error'); // set error class to the control group
            },

            success: function (label) {
                label
                    .addClass('valid').addClass('help-inline ok') // mark the current input as valid and display OK icon
                .closest('.control-group').removeClass('error').addClass('success'); // set success class to the control group
            },

            submitHandler: function (form) {
                success1.show();
                error1.hide();
                form1.ajaxSubmit(App.afo(function(data){
    	    		//登录成功跳转到上一界面
                	$("#queryForm").submit();
    	    	}));
                return false;
            }
        });
	};
	
	function selectState(){
		var index = parent.layer.getFrameIndex(window.name);
		$(".selectState").click(function(){
			$id = $(this).attr("data-set");
			$valName = $(this).attr("data-val");
			parent.$('#selectParent').val($valName);
			parent.$('#selectParentId').val($id);
			parent.layer.close(index);
		}); 
	}; 
	
	return { 
		init : function(){
			jQuery('#sample_1 .group-checkable').change(function () {
                var set = jQuery(this).attr("data-set");
                var checked = jQuery(this).is(":checked");
                jQuery(set).each(function () {
                    if (checked) {
                        $(this).attr("checked", true);
                    } else {
                        $(this).attr("checked", false);
                    }
                });
                jQuery.uniform.update(set);
            });

			
            $("#del").click(function(){
            	var ids = [];
            	$("#sample_1 .checkboxes").each(function(){
            		if($(this).is(":checked")){
            			ids[ids.length] = $(this).val();
            		}
            	});
            	if(ids.length < 1) return ;
            	swal({   
            		title: "Are you sure?",   
            		text: "确认删除选中的用户信息?",
            		type: "warning",   
            		showCancelButton: true,   
            		confirmButtonColor: "#DD6B55",   
            		confirmButtonText: "确定删除!",
            		cancelButtonText : "取消",
            		closeOnConfirm: false 
            		}, function(){   
            			$.post($basePath + "adminUser/user/deletion",{idsStr:JSON.stringify(ids)},function(data){
            				if(!data.success){
            					swal("Error!", data.data, "error");
            				}else{
            					"Deleted!", "删除成功", "success"
            					swal({
            						title : "Deleted!",
            						text : "删除成功",
            						type : "success"
            					},function(){ 
            						$("#queryForm").submit();
            					});
            				}
                		});
            		});
            });
		},
		
		
		initOperation : function(){
			$("#cancel").click(function(){
	        	$("#queryForm").submit();
	        });
            $("#btntext").on("click",function(){
                layer.open({
                    type: 2,
                    //skin: 'layui-layer-lan',
                    title: '用户列表',
                    fix: false,
                    shadeClose: true,
                    maxmin: false,
                    area: ['1000px', '500px'],
                    content: '../../adminUser/user/listParentPage',
                });
            });
			handleValidation();
		},
		
		dataOperation : function(id){
			$("#queryForm").attr("action",$basePath + "adminUser/user/editPage?id="+id);
			$("#queryForm").submit();
		},
		
		selectState:function(){
			selectState();
		}
	}
}();