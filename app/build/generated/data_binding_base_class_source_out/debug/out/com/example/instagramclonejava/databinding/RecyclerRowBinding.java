// Generated by view binder compiler. Do not edit!
package com.example.instagramclonejava.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.instagramclonejava.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class RecyclerRowBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView recyclerViewCommentText;

  @NonNull
  public final ImageView recyclerViewImageView;

  @NonNull
  public final TextView recyclerViewUserEmailText;

  private RecyclerRowBinding(@NonNull LinearLayout rootView,
      @NonNull TextView recyclerViewCommentText, @NonNull ImageView recyclerViewImageView,
      @NonNull TextView recyclerViewUserEmailText) {
    this.rootView = rootView;
    this.recyclerViewCommentText = recyclerViewCommentText;
    this.recyclerViewImageView = recyclerViewImageView;
    this.recyclerViewUserEmailText = recyclerViewUserEmailText;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RecyclerRowBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RecyclerRowBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.recycler_row, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RecyclerRowBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.recyclerViewCommentText;
      TextView recyclerViewCommentText = ViewBindings.findChildViewById(rootView, id);
      if (recyclerViewCommentText == null) {
        break missingId;
      }

      id = R.id.recyclerViewImageView;
      ImageView recyclerViewImageView = ViewBindings.findChildViewById(rootView, id);
      if (recyclerViewImageView == null) {
        break missingId;
      }

      id = R.id.recyclerViewUserEmailText;
      TextView recyclerViewUserEmailText = ViewBindings.findChildViewById(rootView, id);
      if (recyclerViewUserEmailText == null) {
        break missingId;
      }

      return new RecyclerRowBinding((LinearLayout) rootView, recyclerViewCommentText,
          recyclerViewImageView, recyclerViewUserEmailText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}