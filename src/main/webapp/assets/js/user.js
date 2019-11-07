//
function deleteUser(id){
	isDelete = confirm("你确定要删除数据吗");
	if(isDelete){
		window.location.href='deleteuser/'+id;
	}
}

function updateUser(id){
	window.location.href='updateuser/'+id;
}