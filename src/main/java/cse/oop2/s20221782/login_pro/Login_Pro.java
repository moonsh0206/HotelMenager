/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cse.oop2.s20221782.login_pro;

/**
 *
 * @author byj10
 */
import javax.swing.*;

public class Login_Pro extends JFrame {
private JTextField nameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login_Pro() {
        // JFrame 설정
        setTitle("호텔 로그인 시스템");
        setSize(300, 130);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 중앙에 위치

        // 컴포넌트 생성
        nameField = new JTextField(17);
        passwordField = new JPasswordField(17);
        loginButton = new JButton("로그인");

        // 로그인 버튼 클릭 이벤트 처리
        loginButton.addActionListener(e -> authenticateUser());

        // 패널에 컴포넌트 추가
        JPanel panel = new JPanel();
        panel.add(new JLabel("     이름:  "));
        panel.add(nameField);
        panel.add(new JLabel("비밀번호:"));
        panel.add(passwordField);
        panel.add(loginButton);

        // 패널을 JFrame에 추가
        add(panel);
    }

    private void authenticateUser() {
        // 예시 사용자 인증 로직
        String name = nameField.getText();
        String password = new String(passwordField.getPassword());

        // 간단한 인증 로직
        if (name.contains("user") && password.equals("123hotel")) {
            showUserScreen(name);
        } else {
            showFailureScreen();
        }
    }

    private void showUserScreen(String name) {
        // 사용자 역할에 따라 다른 화면 표시
        if (name.contains("M")) {
            JOptionPane.showMessageDialog(this, "로그인 완료. 관리자: " + name);
        } else {
            JOptionPane.showMessageDialog(this, "로그인 완료. 직원: " + name);
        }
    }

    private void showFailureScreen() {
        // 로그인 실패 메시지
        JOptionPane.showMessageDialog(this, "로그인 실패. 다시 입력해주세요.");
    }

    public static void main(String[] args) {
        // JFrame을 이벤트 스레드에서 생성
        SwingUtilities.invokeLater(() -> {
            new Login_Pro().setVisible(true); // JFrame 보이기
        });
    }
}