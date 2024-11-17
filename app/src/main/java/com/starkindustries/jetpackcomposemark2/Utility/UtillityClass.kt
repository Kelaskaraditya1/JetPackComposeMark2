package com.starkindustries.jetpackcomposemark2.Utility
import com.starkindustries.jetpackcomposemark2.Data.ProfileData
import com.starkindustries.jetpackcomposemark2.R

class UtillityClass {
    companion object{
        @JvmStatic
        fun getData():ArrayList<ProfileData>{
            val profileList=ArrayList<ProfileData>()
            profileList.add(ProfileData(R.drawable.casual_pic,"Aditya","Android Developer"))
            profileList.add(ProfileData(R.drawable.casual_pic,"Mayur","Api Key"))
            profileList.add(ProfileData(R.drawable.casual_pic,"Sandesh","Kratos"))
            profileList.add(ProfileData(R.drawable.casual_pic,"Aaryaman","Reverse String"))
            profileList.add(ProfileData(R.drawable.casual_pic,"Aditya","Android Developer"))
            profileList.add(ProfileData(R.drawable.casual_pic,"Aditya","Android Developer"))
            profileList.add(ProfileData(R.drawable.casual_pic,"Aditya","Android Developer"))
            profileList.add(ProfileData(R.drawable.casual_pic,"Aditya","Android Developer"))
            profileList.add(ProfileData(R.drawable.casual_pic,"Aditya","Android Developer"))
            profileList.add(ProfileData(R.drawable.casual_pic,"Aditya","Android Developer"))
            profileList.add(ProfileData(R.drawable.casual_pic,"Aditya","Android Developer"))
            profileList.add(ProfileData(R.drawable.casual_pic,"Aditya","Android Developer"))
            profileList.add(ProfileData(R.drawable.casual_pic,"Aditya","Android Developer"))
            profileList.add(ProfileData(R.drawable.casual_pic,"Aditya","Android Developer"))
            profileList.add(ProfileData(R.drawable.casual_pic,"Aditya","Android Developer"))
            profileList.add(ProfileData(R.drawable.casual_pic,"Aditya","Android Developer"))
            profileList.add(ProfileData(R.drawable.casual_pic,"Aditya","Android Developer"))
            profileList.add(ProfileData(R.drawable.casual_pic,"Aditya","Android Developer"))
            return profileList
        }
    }

}