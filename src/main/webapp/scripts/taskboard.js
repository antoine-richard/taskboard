
/** Taskboard namespace */
var Taskboard = Taskboard || {};

/**
 * Submit the add task form if a label has been filled
 */
Taskboard.add = function() {
	if (!document.getElementById("label").value)
		alert("Please, label your task.");
	else
		document.addForm.submit();
};