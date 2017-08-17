package com.hy.ioms.utils;

import android.databinding.ObservableList;
import android.util.Pair;

import com.hy.ioms.model.dto.FilterDTO;
import com.hy.ioms.model.dto.TreeNodeDTO;
import com.hy.ioms.model.vo.SpinItemVO;
import com.hy.ioms.view.ui.spinner.FilterSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * ${description}
 * Created by wsw on 2017/8/17.
 */

public class TreeNodeUtils {

    public static void treeNodeAnalysis(List<TreeNodeDTO> treeNodeDTOs, FilterDTO filterDTO,
                                        ObservableList<SpinItemVO> companyList,
                                        ObservableList<SpinItemVO> circuitList,
                                        ObservableList<SpinItemVO> poleList) {
        companyList.clear();
        circuitList.clear();
        poleList.clear();
        treeNodeAnalysis(treeNodeDTOs, filterDTO,companyList , circuitList, poleList, new ArrayList<>());
    }


    public static void treeNodeAnalysis(List<TreeNodeDTO> treeNodeDTOs, FilterDTO filterDTO,
                                        List<SpinItemVO> companyList) {
        treeNodeAnalysis(treeNodeDTOs, filterDTO, companyList, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public static void treeNodeAnalysis(List<TreeNodeDTO> treeNodeDTOs, FilterDTO filterDTO,
                                        List<SpinItemVO> companyList,
                                        List<SpinItemVO> circuitList) {
        treeNodeAnalysis(treeNodeDTOs, filterDTO, companyList, circuitList, new ArrayList<>(), new ArrayList<>());
    }

    public static void treeNodeAnalysis(List<TreeNodeDTO> treeNodeDTOs, FilterDTO filterDTO,
                                        List<SpinItemVO> companyList,
                                        List<SpinItemVO> circuitList,
                                        List<SpinItemVO> poleList) {
        treeNodeAnalysis(treeNodeDTOs, filterDTO, companyList, circuitList, poleList, new ArrayList<>());
    }

    public static void treeNodeAnalysis(List<TreeNodeDTO> treeNodeDTOs, FilterDTO filterDTO,
                                        List<SpinItemVO> companyList,
                                        List<SpinItemVO> circuitList,
                                        List<SpinItemVO> poleList,
                                        List<SpinItemVO> deviceList) {
        List<TreeNodeDTO> companies = new ArrayList<>();

        //取出二级公司的TreeNode,作为companyTreeNode
        for (TreeNodeDTO treeNodeDTO : treeNodeDTOs) {
            if (treeNodeDTO.getChildren().size() > 0 && treeNodeDTO.getChildren().get(0).getType().equals("company")) {
                companies.addAll(treeNodeDTO.getChildren());
            } else {
                companies.add(treeNodeDTO);
            }
        }

        for (TreeNodeDTO company : companies) {
            //加入公司列表
            companyList.add(new SpinItemVO(company.getName(), FilterSpinnerAdapter.COMPANY, company.getId()));
            //根据条件查找符合条件的线路
            if (filterDTO.getCompanyId() == 0 || filterDTO.getCompanyId() == company.getId()) {
                for (TreeNodeDTO circuit : company.getChildren()) {
                    circuitList.add(new SpinItemVO(circuit.getName(), FilterSpinnerAdapter.CIRCUIT, circuit.getId()));
                    //根据条件查找符合条件的杆塔
                    if (filterDTO.getCircuitId() == 0 || filterDTO.getCircuitId() == circuit.getId()) {
                        for (TreeNodeDTO pole : circuit.getChildren()) {
                            poleList.add(new SpinItemVO(pole.getName(), FilterSpinnerAdapter.POLE, pole.getId()));
                            //根据条件查找符合条件的设备
                            if (filterDTO.getPoleId() == 0 || filterDTO.getPoleId() == pole.getId()) {
                                for (TreeNodeDTO device : pole.getChildren()) {
                                    deviceList.add(new SpinItemVO(device.getName(), FilterSpinnerAdapter.DEVICE, device.getId()));
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("over");
    }

}
