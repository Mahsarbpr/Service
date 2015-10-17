var form_name = 'ftc_register';
$('Document').ready(function() {
  var content_height = parseInt( $('#content_standard').css('height'), 10 );
  $('#school_type').change(function() {
    if(this.value == 'other') {
      $('#school_type_other_wrapper').removeClass('hidden');
      content_height += 68;
      $('#content_standard').css('height', content_height + "px");
      $('#left_info').css('height', content_height + "px");
    } else {
      if (!$('#school_type_other_wrapper').hasClass('hidden')) {
        $('#school_type_other_wrapper').addClass('hidden');
      }
    }
  });

  $('#marketing_stream').change(function() {
    if(this.value == 'other') {
      $('#marketing_stream_other_wrapper').removeClass('hidden');
      content_height += 68;
      $('#content_standard').css('height', content_height + "px");
      $('#left_info').css('height', content_height + "px");
    } else {
      if (!$('#school_type_other_wrapper').hasClass('hidden')) {
        $('#school_type_other_wrapper').addClass('hidden');
      }
    }
  });


  $('#' + form_name).submit(function(event) {
    var errors_found = false;
        $("input").each(function(index,data) {
      if ($(this).hasClass('required') && $(this).val().length == 0) {
        errors_found = true;
        var id = $(this).attr('id');
        $(this).addClass('error');
        $("label[for='" + id + "']").addClass('error');
      }
    });
    $("select").each(function(index, data) {
      if ($(this).hasClass('required') && $(this).attr('value') == 0) {
        errors_found = true;
        var id = $(this).attr('id');
        $(this).addClass('error');
        $("label[for='" + id + "']").addClass('error');
      }
    });
    if (errors_found) {
      alert("There were errors in your registration form. They are in red.");
      event.preventDefault();
    }
  });
  //Remove error classes on click
  $('.error').click(function() {
    $(this).removeClass('error');
  });
  $("select").change(function() {
    if ($(this).hasClass('error')) {
      var id = $(this).attr('id');
      $(this).removeClass('error');
      $("label[for='" + id + "']").removeClass('error');
    }
  });
});
