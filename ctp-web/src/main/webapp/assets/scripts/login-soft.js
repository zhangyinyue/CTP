var Login = function () {

	var handleLogin = function() {
		$('.login-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            rules: {
	            	fname: {
	                    required: true
	                },
	                fpwd: {
	                    required: true
	                },
	                isSaveToLocale: {
	                    required: false
	                }
	            },

	            messages: {
	            	fname: {
	                    required: "帐号不能为空."
	                },
	                fpwd: { 
	                    required: "密码不能为空."
	                }
	            },
	            highlight: function (element) { // hightlight error inputs
	                $(element)
	                    .closest('.control-group').addClass('error'); // set error class to the control group
	            },
	            success: function (label) {
	                label.closest('.control-group').removeClass('error');
	                label.remove();
	            },
	            errorPlacement: function (error, element) {
	                error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	            }
	        });

	        $('.login-form input').keypress(function (e) {
	            if (e.which == 13) {
	            	submit();
	                return false;
	            }
	        });
	};

	function submit(){
		if ($('#loginForm').validate().form()) {
			$("#loginForm").ajaxSubmit(App.afo(function(data){
	    		//登录成功跳转到首页
				if(data==true){
					window.location.href = basePath + "adminUser/homePage";
				}else{
					$("#error").text(data);
				}
	    	}));
        } 
	};
	
    return {
        //main function to initiate the module
        init: function () {
        	
            handleLogin();
            
            $("#btnAjaxSubmit").click(function(){
            	submit();
            	$("#error").text("");
            	return false;
            });

            $.backstretch([
		        "../assets/img/bg/1.jpg",
		        "../assets/img/bg/2.jpg",
		        "../assets/img/bg/3.jpg",
		        "../assets/img/bg/4.jpg"
		        ], { 
		          fade: 1000,
		          duration: 8000
		    });
	       
        }

    };

}();