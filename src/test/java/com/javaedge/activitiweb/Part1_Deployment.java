package com.javaedge.activitiweb;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

@SpringBootTest
public class Part1_Deployment {

    @Autowired
    private RepositoryService repoService;

    //通过bpmn部署流程
    @Test
    public void initDeploymentBPMN() {
        String filename = "BPMN/Part4_Task_claim.bpmn";
//         String pngname="BPMN/Part1_Deployment.png";
        Deployment deployment = repoService.createDeployment()
                .addClasspathResource(filename)
//                .addClasspathResource(pngname)//图片
                .name("流程部署测试V1")
                .deploy();
        System.out.println(deployment.getName());
    }

    @Test
    public void startDeploymentBPMN() {
        String filename = "BPMN/Part4_Task.bpmn";
        Deployment deployment = repoService.createDeployment()
                .addClasspathResource(filename)
                .name("Part4_Task")
                .deploy();
    }

    //通过ZIP部署流程
    @Test
    public void initDeploymentZIP() {
        InputStream fileInputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("BPMN/Part1_DeploymentV2.zip");
        ZipInputStream zip = new ZipInputStream(fileInputStream);
        Deployment deployment = repoService.createDeployment()
                .addZipInputStream(zip)
                .name("流程部署测试zip")
                .deploy();
        System.out.println(deployment.getName());
    }

    //查询流程部署
    @Test
    public void getDeployments() {
        List<Deployment> list = repoService.createDeploymentQuery().list();
        for (Deployment dep : list) {
            System.out.println("Id：" + dep.getId());
            System.out.println("Name：" + dep.getName());
            System.out.println("DeploymentTime：" + dep.getDeploymentTime());
            System.out.println("Key：" + dep.getKey());
        }
    }
}