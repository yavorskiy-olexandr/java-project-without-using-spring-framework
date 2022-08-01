$(document).ready(
		function() {
			$('button.createProduct').click(
					function() {
						var name = $("form.createProduct input.productName")
								.val();
						var description = $(
								"form.createProduct input.productDescription")
								.val();
						var price = $("form.createProduct input.productPrice")
								.val();
						var userProduct = {
							name : name,
							description : description,
							price : price
						};
						$.post("product", userProduct, function(data) {
							$("form")[0].reset();
						});
						return false;
					});
			$("button.buy-product").click(function() {
				var productId = jQuery(this).attr("product-id");

				$.post("bucket", {'productId' : productId}, function(data) {
					if (data == 'Success') {
						$('[data-dismiss=modal]').trigger({type : 'click'});
					}
				});
				return false;
			});
		});