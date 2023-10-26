(function($) {

	"use strict";

	var fullHeight = function() {

		$('.js-fullheight').css('height', $(window).height());
		$(window).resize(function(){
			$('.js-fullheight').css('height', $(window).height());
		});

	};
	fullHeight();

	$('#sidebarCollapse').on('click', function () {
      $('#sidebar').toggleClass('active');
  });

})(jQuery);

function delUser(path, login) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Something wrong!!!");
        });
    }
}
function apply(path, motelId) {
    if (confirm("Bạn chắc chắn Apply không?") === true) {
        fetch(path, {
            method: "post"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Something wrong!!!");
        });
    }
}
function follow(path, renter, host) {
    fetch(path, {
        method: "post"
    }).then(res => {
        if (res.status === 204)
            location.reload();
        else
            alert("Something wrong!!!");
    });
}
function unFollow(path, renter, host) {
    fetch(path, {
        method: "post"
    }).then(res => {
        if (res.status === 204)
            location.reload();
        else
            alert("Something wrong!!!");
    });
}
function indexUser(path) {
    if (confirm("Chuyển trang") === true) {
        fetch(path, {
            method: "get"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Something wrong!!!");
        });
    }
}