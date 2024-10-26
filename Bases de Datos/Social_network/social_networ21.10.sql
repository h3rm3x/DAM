-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 21, 2024 at 07:01 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `social_network`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitter_user`
--

CREATE TABLE `chitter_user` (
  `user_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(15) 
  `encrypted_pw` varchar(20) ,
  `email` varchar(50) ,
  `date_joined` datetime 
) ;

--
-- Dumping data for table `chitter_user`
--

INSERT INTO `chitter_user` (`user_id`, `username`, `encrypted_pw`, `email`, `date_joined`) VALUES
(1, 'user1', 'password1', 'fakemail@fakeadress.com', '2024-10-16 21:17:05'),
(2, 'user2', 'password2', 'fakemail1@fakeadress.com', '2024-10-16 21:08:03'),
(3, 'user3', 'password3', 'fakemail2@fakeadress.com', '2024-10-16 15:24:04'),
(4, 'user4', 'password4', 'fakemail3@fakeadress.com', '2024-10-16 21:18:04'),
(5, 'user5', 'password5', 'fakemail4@fakeadress.com', '2024-10-16 22:01:45'),
(6, 'user6', 'password6', 'fakemail5@fakeadress.com', '2024-10-16 22:04:33'),
(7, 'user7', 'password7', 'fakemail6@fakeadress.com', '2024-10-16 23:28:58'),
(8, 'user8', 'password8', 'fakemail7@fakeadress.com', '2024-10-16 21:08:04'),
(9, 'user9', 'password9', 'fakemail8@fakeadress.com', '2024-10-16 10:21:40'),
(10, 'user10', 'password10', 'fakemail9@fakeadress.com', '2024-10-16 20:18:17');

-- --------------------------------------------------------

--
-- Table structure for table `follower`
--

CREATE TABLE `follower` (
  `follower_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY(follower_id,user_id),
  FOREIGN KEY (follower_id) REFERENCES chitter_user(user_id),
  FOREIGN KEY(user_id) REFERENCES chitter_user(user_id)
) ;

--
-- Dumping data for table `follower`
--

INSERT INTO `follower` (`follower_id`, `user_id`) VALUES
(1, 3),
(2, 4),
(3, 1),
(4, 6),
(5, 10),
(6, 9),
(7, 8),
(7, 9),
(8, 9),
(9, 7),
(10, 9);

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `post_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `user_id` int(11) NOT NULL ,
  `content` varchar(300) ,
  `posted_at` datetime DEFAULT current_timestamp(),
  FOREIGN KEY (user_id) REFERENCES chitter_user(user_id)
) 

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`post_id`, `user_id`, `content`, `posted_at`) VALUES
(1, 1, '“Great minds discuss ideas; average minds discuss events; small minds discuss people.” – Eleanor Roosevelt', '2024-10-17 17:49:06'),
(2, 2, '“He who has a why to live can bear almost any how.” – Friedrich Nietzsche', '2024-10-17 17:49:06'),
(3, 3, ' “The best revenge is massive success.” – Frank Sinatra', '2024-10-17 17:49:06'),
(4, 4, ' “The best revenge is massive success.” – Frank Sinatra', '2024-10-17 17:49:06'),
(5, 5, ' “The best revenge is massive success.” – Frank Sinatra', '2024-10-17 17:49:06'),
(6, 6, ' “The best revenge is massive success.” – Frank Sinatra', '2024-10-17 17:49:06'),
(7, 7, ' “The best revenge is massive success.” – Frank Sinatra', '2024-10-17 17:49:06'),
(8, 8, ' “The best revenge is massive success.” – Frank Sinatra', '2024-10-17 17:49:06'),
(9, 9, ' “The best revenge is massive success.” – Frank Sinatra', '2024-10-17 17:49:06'),
(10, 10, ' “The best revenge is massive success.” – Frank Sinatra', '2024-10-17 17:49:06'),
(11, 1, 'The greatest glory in living lies not in never falling but in rising every time we fall. -Nelson Mandela ', '2024-10-21 18:21:54'),
(12, 3, 'The way to get started is to quit talking and begin doing. -Walt Disney ', '2024-10-21 18:21:54'),
(13, 2, 'Your time is limited, so don\'t waste it living someone else\'s life. Don\'t be trapped by dogma – which is living with the results of other people\'s thinking. -Steve Jobs \n3,The future belongs to those who believe in the beauty of their dreams. -Eleanor Roosevelt ', '2024-10-21 18:21:54'),
(14, 4, 'If you look at what you have in life, you\'ll always have more. If you look at what you don\'t have in life, you\'ll never have enough. -Oprah Winfrey ', '2024-10-21 18:21:54'),
(15, 5, 'If you set your goals ridiculously high and it\'s a failure, you will fail above everyone else\'s success. -James Cameron ', '2024-10-21 18:21:54'),
(16, 6, 'You may say I\'m a dreamer, but I\'m not the only one. I hope someday you\'ll join us. And the world will live as one. -John Lennon', '2024-10-21 18:21:54'),
(17, 7, 'You must be the change you wish to see in the world. -Mahatma Gandhi ', '2024-10-21 18:21:54'),
(18, 8, 'Spread love everywhere you go. Let no one ever come to you without leaving happier. -Mother Teresa', '2024-10-21 18:21:54'),
(19, 9, 'The only thing we have to fear is fear itself. -Franklin D. Roosevelt', '2024-10-21 18:21:54'),
(20, 10, 'Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that. -Martin Luther King Jr.', '2024-10-21 18:21:54'),
(21, 10, '“I think therefore I am. – René Descartes', '2024-10-21 18:36:21'),
(22, 10, '“The only impossible journey is the one you never begin.– Tony Robbins', '2024-10-21 18:36:21'),
(23, 10, '“Change your thoughts and you change your world. – Norman Vincent Peale', '2024-10-21 18:36:21'),
(24, 10, '“Life is 10% what happens to us and 90% how we react to it.– Charles R. Swindoll', '2024-10-21 18:36:21'),
(25, 10, 'The best time to plant a tree was 20 years ago. The second best time is now. – Chinese Proverb', '2024-10-21 18:36:21'),
(26, 10, '“An unexamined life is not worth living. – Socrates', '2024-10-21 18:36:21'),
(27, 10, ' “Turn your wounds into wisdom. – Oprah Winfrey', '2024-10-21 18:36:21'),
(28, 10, '“The purpose of our lives is to be happy. – Dalai Lama', '2024-10-21 18:36:21'),
(29, 8, '“Life is really simple but we insist on making it complicated.– Confucius', '2024-10-21 18:36:21'),
(30, 8, ' “Happiness is not something ready made. It comes from your own actions. – Dalai Lama', '2024-10-21 18:36:21'),
(31, 8, '“You only live once but if you do it right once is enough – Mae West', '2024-10-21 18:36:21'),
(32, 1, '“Get busy living or get busy dying. – Stephen King', '2024-10-21 18:36:21'),
(33, 1, '“The big lesson in life baby is never be scared of anyone or anything. – Frank Sinatra', '2024-10-21 18:36:21'),
(34, 1, '“Life is like riding a bicycle. To keep your balance you must keep moving. – Albert Einstein', '2024-10-21 18:36:21'),
(35, 1, '“The purpose of life is not to be happy. It is to be useful to be honourable to be compassionate to have it make some difference that you have lived and lived well. – Ralph Waldo Emerson', '2024-10-21 18:36:21'),
(36, 1, '“In three words I can sum up everything I’ve learned about life: It goes on. – Robert Frost', '2024-10-21 18:36:21'),
(37, 1, '“Life is a journey that must be travelled no matter how bad the roads and accommodations. – Oliver Goldsmith', '2024-10-21 18:36:21'),
(38, 1, '“Life is a succession of lessons which must be lived to be understood.– Helen Keller ', '2024-10-21 18:36:21'),
(39, 1, ' “The unexamined life is not worth living. – Socrates', '2024-10-21 18:36:21'),
(40, 2, '“To live is the rarest thing in the world. Most people exist that is all. – Oscar Wilde', '2024-10-21 18:36:21'),
(41, 2, '“Life is never fair and perhaps it is a good thing for most of us that it is not. – Oscar Wilde', '2024-10-21 18:36:21'),
(42, 2, '“The only way out of the labyrinth of suffering is to forgive. – John Green', '2024-10-21 18:36:21'),
(43, 3, '“The purpose of life is to believe to hope and to strive. – Indira Gandhi', '2024-10-21 18:36:21'),
(44, 3, '“Life is what happens when you’re busy making other plans. – John Lennon', '2024-10-21 18:36:22'),
(45, 3, '“The healthiest response to life is joy. – Deepak Chopra', '2024-10-21 18:36:22'),
(46, 3, '“Life is short and it is up to you to make it sweet. – Sarah Louise Delany ', '2024-10-21 18:36:22'),
(47, 3, ' “Life is what we make it always has been always will be. – Grandma Moses', '2024-10-21 18:36:22'),
(48, 3, '“Life’s tragedy is that we get old too soon and wise too late.– Benjamin Franklin', '2024-10-21 18:36:22'),
(49, 3, '“Life is a long lesson in humility. – James M. Barrie ', '2024-10-21 18:36:22'),
(50, 3, ' “Believe you can and you’re halfway there – Theodore Roosevelt', '2024-10-21 18:36:22'),
(51, 4, '“Start where you are. Use what you have. Do what you can. – Arthur Ashe', '2024-10-21 18:36:22'),
(52, 4, ' “Act as if what you do makes a difference. It does. – William James', '2024-10-21 18:36:22'),
(53, 4, '“Life is either a daring adventure or nothing at all  – Helen Keller ', '2024-10-21 18:36:22'),
(54, 4, ' “When you have a dream you’ve got to grab it and never let go. – Carol Burnett', '2024-10-21 18:36:22'),
(55, 4, '  “Limit your ‘always’ and your nevers. – Amy Poehler', '2024-10-21 18:36:22'),
(56, 4, ' “Nothing is impossible. The word itself says I\'m possible! – Audrey Hepburn', '2024-10-21 18:36:22'),
(57, 4, '“Life is a dream for the wise a game for the fool a comedy for the rich a tragedy for the poor. – Sholom Aleichem ', '2024-10-21 18:36:22'),
(58, 4, ' “You are never too old to set another goal or to dream a new dream. – C.S. Lewis', '2024-10-21 18:36:22'),
(59, 4, '  “Try to be a rainbow in someone else’s cloud.  – Maya Angelou', '2024-10-21 18:36:22'),
(60, 4, ' “You do not find the happy life. You make it. – Camilla Eyring Kimball', '2024-10-21 18:36:22'),
(61, 4, '“Life is trying things to see if they work. – Ray Bradbury ', '2024-10-21 18:36:22'),
(62, 5, ' “The most wasted of days is one without laughter. – E.E. Cummings', '2024-10-21 18:36:22'),
(63, 5, '  “You get in life what you have the courage to ask for. – Oprah Winfrey', '2024-10-21 18:36:22'),
(64, 5, ' “What you get by achieving your goals is not as important as what you become by achieving your goals. – Zig Ziglar', '2024-10-21 18:36:22'),
(65, 5, '“Your time is limited don’t waste it living someone else’s life. – Steve Jobs ', '2024-10-21 18:36:22'),
(66, 5, ' “Life changes very quickly in a very positive way if you let it. – Lindsey Vonn', '2024-10-21 18:36:22'),
(67, 5, '  “Keep your face always toward the sunshine and shadows will fall behind you. – Walt Whitman', '2024-10-21 18:36:22'),
(68, 5, ' “Find out who you are and do it on purpose. – Dolly Parton', '2024-10-21 18:36:22'),
(69, 5, '“Life is not a problem to be solved but a reality to be experienced. – Søren Kierkegaard', '2024-10-21 18:36:22'),
(70, 5, '“The most important thing is to enjoy your life—to be happy—it’s all that matters. – Audrey Hepburn', '2024-10-21 18:36:22'),
(71, 5, ' “I have learned over the years that when one’s mind is made up this diminishes fear. – Rosa Parks', '2024-10-21 18:36:22'),
(72, 5, '“Our lives begin to end the day we become silent about things that matter. – Martin Luther King Jr.', '2024-10-21 18:36:22'),
(73, 5, '“Success usually comes to those who are too busy to be looking for it. – Henry David Thoreau ', '2024-10-21 18:36:22'),
(74, 5, ' “The road to success and the road to failure are almost exactly the same. – Colin R. Davis', '2024-10-21 18:36:22'),
(75, 5, '“Success is not how high you have climbed but how you make a positive difference to the world. – Roy T. Bennett', '2024-10-21 18:36:22'),
(76, 5, ' “Success is liking yourself liking what you do and liking how you do it. – Maya Angelou', '2024-10-21 18:36:22'),
(77, 5, '“Life is short art long opportunity fleeting experience treacherous judgment difficult. – Hippocrates ', '2024-10-21 18:36:22'),
(78, 5, '“Don’t watch the clock; do what it does. Keep going.” – Sam Levenson ', '2024-10-21 18:36:22'),
(79, 6, ' “Success is stumbling from failure to failure with no loss of enthusiasm. – Winston S. Churchill', '2024-10-21 18:36:22'),
(80, 6, '“Success isn’t just about what you accomplish in your life; it’s about what you inspire others to do. – Unknown', '2024-10-21 18:36:22'),
(81, 6, '“Not life but good life is to be chiefly valued – Socrates ', '2024-10-21 18:36:22'),
(82, 6, ' “Some people dream of success while other people get up every morning and make it happen. – Wayne Huizenga', '2024-10-21 18:36:22'),
(83, 6, '  “To succeed in life you need two things: ignorance and confidence. – Mark Twain”.', '2024-10-21 18:36:22'),
(84, 6, ' “Success is not final failure is not fatal: It is the courage to continue that counts. – Winston Churchill”', '2024-10-21 18:36:22'),
(85, 6, '“Life is a flower of which love is the honey.– Victor Hugo” ', '2024-10-21 18:36:22'),
(86, 6, ' “The only place where success comes before work is in the dictionary. – Vidal Sassoon', '2024-10-21 18:36:22'),
(87, 6, '  “I find that the harder I work the more luck I seem to have. – Thomas Jefferson”', '2024-10-21 18:36:22'),
(88, 7, ' “The secret of success is to do the common thing uncommonly well.– John D. Rockefeller Jr.” ', '2024-10-21 18:36:22'),
(89, 7, '“Life without love is like a tree without blossoms or fruit.– Khalil Gibran”  ', '2024-10-21 18:36:22'),
(90, 7, '“Success is the sum of small efforts repeated day in and day out. – Robert Collier ', '2024-10-21 18:36:22'),
(91, 7, ' “I never dreamed about success I worked for it.– Estée Lauder” ', '2024-10-21 18:36:22'),
(92, 7, '“Success is going from failure to failure without losing your enthusiasm. – Winston Churchill”', '2024-10-21 18:36:22'),
(93, 7, '“The good life is one inspired by love and guided by knowledge. – Bertrand Russell”', '2024-10-21 18:36:22'),
(94, 7, '“Don’t be afraid to give up the good to go for the great. – John D. Rockefeller ”', '2024-10-21 18:36:22'),
(95, 7, '“The secret to success is to know something nobody else knows. – Aristotle Onassis ”', '2024-10-21 18:36:22'),
(96, 7, ' “Success is where preparation and opportunity meet.– Bobby Unser” ', '2024-10-21 18:36:22'),
(97, 7, '“The key to success is to focus on goals not obstacles.– Unknown ” ', '2024-10-21 18:36:22'),
(98, 7, ' “Success doesn’t come to you you go to it.– Marva Collins” ', '2024-10-21 18:36:22'),
(99, 8, '“Your success and happiness lie in you. Resolve to keep happy and your joy and you shall form an invincible host against difficulties.” – Helen Keller ', '2024-10-21 18:36:22'),
(100, 8, ' “The only limit to our realization of tomorrow will be our doubts of today. – Franklin D. Roosevelt”', '2024-10-21 18:36:22'),
(101, 8, '“Success is how high you bounce when you hit bottom. – George S. Patton”', '2024-10-21 18:36:22'),
(102, 8, '“To be successful you must accept all challenges that come your way. You can’t just accept the ones you like. – Mike Gafka.”', '2024-10-21 18:36:22'),
(103, 8, '“The ladder of success is best climbed by stepping on the rungs of opportunity. – Ayn Rand.”', '2024-10-21 18:36:22'),
(104, 8, '“There are no secrets to success. It is the result of preparation hard work and learning from failure. – Colin Powell”', '2024-10-21 18:36:22'),
(105, 9, '“I have a dream. – Martin Luther King Jr.”', '2024-10-21 18:36:22'),
(106, 9, '“Keep calm and carry on. – British Government”', '2024-10-21 18:36:22'),
(107, 9, '“The only real failure in life is not to be true to the best one knows. – Buddha”', '2024-10-21 18:36:22'),
(108, 9, '“Speak softly and carry a big stick; you will go far. – Theodore Roosevelt”', '2024-10-21 18:36:22'),
(109, 9, '“That which does not kill us makes us stronger.”– Friedrich Nietzsche ', '2024-10-21 18:36:22');

