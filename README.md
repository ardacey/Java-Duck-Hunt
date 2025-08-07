# Duck Hunt Game

A classic Duck Hunt game implementation built with Java and JavaFX, recreating the nostalgic arcade shooting experience.

## 🎮 About

This project is a faithful recreation of the classic Duck Hunt arcade game. Players aim and shoot at flying ducks across multiple levels, featuring authentic animations, sound effects, and game mechanics that stay true to the original experience.

## ✨ Features

- **Classic Gameplay**: Traditional duck hunting mechanics with moving targets
- **Multiple Levels**: Progressive difficulty with different duck patterns
- **Authentic Graphics**: Pixel-perfect sprites scaled for modern screens
- **Sound Effects**: Immersive audio experience with classic game sounds
- **Smooth Animations**: Fluid duck movements and shooting animations
- **Score System**: Track your hunting performance across levels
- **User Interface**: Clean, intuitive game interface with options menu

## 🛠️ Technologies Used

- **Java**: Core game logic and structure
- **JavaFX**: Graphics rendering and user interface
- **Object-Oriented Design**: Clean, modular code architecture

## 📋 Prerequisites

- Java 11 or earlier (recommended for built-in JavaFX support)
- OR Java 8+ with JavaFX installed as a separate library
- Windows/macOS/Linux compatible

## 🚀 Installation & Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Java-Duck-Hunt-main
   ```

2. **Navigate to source directory**
   ```bash
   cd src
   ```

3. **Compile the game**
   ```bash
   javac DuckHunt.java
   ```

4. **Run the game**
   ```bash
   java DuckHunt
   ```

## 🎯 How to Play

1. **Start the Game**: Launch the application to see the welcome screen
2. **Aim and Shoot**: Use your mouse to aim at the flying ducks
3. **Score Points**: Successfully hit ducks to increase your score
4. **Progress Levels**: Complete levels to face new challenges
5. **Adjust Settings**: Use the options menu to customize your experience

## 🏗️ Project Structure

```
src/
├── DuckHunt.java          # Main game class and entry point
├── CustomApplication.java # JavaFX application setup
├── Duck.java             # Duck entity and behavior
├── Welcome.java          # Welcome screen implementation
├── LevelGenerator.java   # Level creation and management
├── Options.java          # Game settings and configuration
├── Move.java             # Movement mechanics
├── AnimationAsset.java   # Animation resources
├── SoundAsset.java       # Audio resources
├── UIAsset.java          # User interface assets
├── TextAsset.java        # Text rendering utilities
└── CustomText.java       # Custom text components
```

## ⚙️ Configuration

The game includes several configurable parameters in `DuckHunt.java`:

- **VOLUME**: Audio volume level (default: 0.025)
- **SCALE**: Graphics scaling factor (default: 3x)
- **WINDOW_WIDTH**: Game window width (768px at 3x scale)
- **WINDOW_HEIGHT**: Game window height (720px at 3x scale)

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🎮 Game Controls

- **Mouse**: Aim your crosshair
- **Left Click**: Shoot at ducks
- **ESC**: Return to main menu (context-dependent)

## 🔧 Troubleshooting

### JavaFX Issues
If you encounter JavaFX-related errors:
- Ensure you're using Java 11 or earlier (includes JavaFX)
- Or install JavaFX separately for newer Java versions
- Add JavaFX to your module path if needed

### Performance Issues
- Try adjusting the SCALE factor in `DuckHunt.java`
- Ensure adequate system resources are available
- Check graphics drivers are up to date

## 🌟 Acknowledgments

- Inspired by the classic Nintendo Duck Hunt game
- Built as an educational project showcasing Java game development
- Thanks to the JavaFX community for excellent documentation

---

**Happy Hunting! 🦆**
