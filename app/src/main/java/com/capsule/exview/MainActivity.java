package com.capsule.exview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.capsule.exview.dialog.BottomTransformDialog;

public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

//        ConstraintFragment fragment = ConstraintFragment.newInstance();
//        getSupportFragmentManager().beginTransaction()
//                                   .add(R.id.fragment_container, fragment, "constraint").commit();
    Button btn = findViewById(R.id.btn);
    btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        BottomTransformDialog dialog = new BottomTransformDialog();
        dialog.show(getSupportFragmentManager(), "bottom");
      }
    });




  }


}
