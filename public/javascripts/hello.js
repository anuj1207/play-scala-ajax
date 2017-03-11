if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
};

$(document).ready(function(){


         $('#btn').on("click",function(){
         jsRoutes.controllers.HomeController.signUpForm().ajax({
                      success: function(data){
                        $('#body').html(data);
                      },
                      error: function(){
                      $('#body').html("hello");
                      alert("fail")
                    }

          })



      })

      $('#btn1').on("click",function(){
                jsRoutes.controllers.HomeController.signInForm().ajax({
                            success: function(data){
                              $('#body').html(data);
                            },
                            error: function(){
                            $('#body').html("hello");
                            alert("fail")
                          }

                })


            })



});
